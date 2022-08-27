package kopo.poly.service.impl;

import kopo.poly.dto.api.ApiLodgingDto;
import kopo.poly.dto.api.introductions.*;
import kopo.poly.enums.LanguageType;
import kopo.poly.exception.ApiException;
import kopo.poly.exception.result.ApiExceptionResult;
import kopo.poly.service.ITourismApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class KorTourismApiService implements ITourismApiService {
    private final DocumentBuilder documentBuilder;
    private final Environment env;

    private final Map<String, String> CONTENT_TYPE_ID_MAP = new HashMap<String, String>() {
        {
            put("TouristDestination", "12"); // 관광지
            put("CulturalFacilities", "14"); // 문화 시설
            put("Festival", "15"); // 축제
            put("TravelCourse", "25"); // only KOR 여행 코스
            put("Leports", "28"); // 레포츠
            put("Lodging", "32"); // 숙박
            put("Shopping", "38"); // 쇼핑
            put("Restaurants", "39"); // 음식점
        }
    };

    @Override
    public boolean supports(LanguageType languageType) {
        return languageType == LanguageType.KOR;
    }

    /**
     * 숙박 정보 조회 (searchStay)
     *
     * @param pageNo      PageNo
     * @param areaCode    지역 코드
     * @param sigunguCode 시군구 코드
     * @return List<LodgingDto> 언어에 맞는 숙박 정보 List
     * @throws Exception
     */
    @Override
    // KOR1 이름으로 Lodging Cache 에 저장 요청 시 KOR1이 있다면 로직을 실행하지 않고 Cache 정보를 return
    @Cacheable(cacheNames = "KorLodging")
    public List<ApiLodgingDto> getLodgingList(
            final LanguageType languageType, final String pageNo, final String areaCode, final String sigunguCode)
            throws Exception {
        log.debug("findAreaCode in " + LanguageType.KOR);
        final URI uri = URI.create(getUri(languageType, "searchStay")
                + "&areaCode=" + areaCode
                + "&sigunguCode=" + sigunguCode
                + "&pageNo=" + pageNo);

        log.info("uri : " + uri);

        final NodeList items = getItemsFromURI(uri);

        List<ApiLodgingDto> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(getLodgingDto(element));
            }
        }
        return result;
    }


    /**
     * 소개 정보 조회 API
     */


    @Override
    public List<FestivalInfoResult> getFestivalInfoList(LanguageType languageType, String contentId) throws Exception {
        return null;
    }

    @Override
    public List<CulturalFacilitiesResult> getCulturalFacilitiesList(LanguageType languageType, String contentId) throws Exception {
        return null;
    }

    @Override
    public List<LeportsResult> getLeportsList(LanguageType languageType, String contentId) throws Exception {
        return null;
    }

    @Override
    public List<LodgingResult> getLodgingList(LanguageType languageType, String contentId) throws Exception {
        return null;
    }

    @Override
    public List<RestaurantsResult> getRestaurantsList(LanguageType languageType, String contentId) throws Exception {
        return null;
    }

    @Override
    public List<ShoppingResult> getShoppingList(LanguageType languageType, String contentId) throws Exception {
        return null;
    }

    @Override
    public List<TouristDestinationResult> getTouristDestinationList(LanguageType languageType, String contentId) throws Exception {
        return null;
    }

    // 여행 코스 조회
    @Override
    public List<TravelCourseResult> getTravelCourseList(LanguageType languageType, String contentId) throws Exception {
        log.info("getTravelCourseList : " + languageType.getLanguageType());
        final URI uri = URI.create(getUri(languageType, "detailIntro")
                + "&contentTypeId=" + CONTENT_TYPE_ID_MAP.get("TravelCourse")
                + "&contentId=" + contentId);

        log.info("uri : " + uri);


        final NodeList items = getItemsFromURI(uri);

        List<TravelCourseResult> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(getTravelCourseResultFromElement(element));
            }
        }

        // 검색된 결과가 없을 경우
        if (result.size() == 0) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        return result;
    }


    /**
     * XML 파일 처리
     */


    private NodeList getItemsFromURI(final URI uri) throws Exception {
        Document doc = documentBuilder.parse(String.valueOf(uri));
        NodeList items = doc.getElementsByTagName("item");

        return items;
    }


    // LanguageType 및 Service 이름을 받아서 Uri return
    private URI getUri(LanguageType languageType, String serviceName) throws URISyntaxException {
        return new URI("https://api.visitkorea.or.kr/openapi/service/rest/" + languageType.getLanguageType() + "/"
                + serviceName + "?"
                + "MobileOS=ETC" // 필수
                + "&MobileApp=AppTest" // 필수
                + "&serviceKey=" + env.getProperty("tourism.key"));
    }


    // XML 파일에서 꺼내온 (Element) 정보에서 Value 가져오기 / if ( Tag 가 없는 경우 or 값이 없는 경우 ) -> return ""
    private String getTagValue(String tag, Element eElement) throws Exception {
        try {
            Optional<NodeList> nlList = Optional.of(eElement.getElementsByTagName(tag).item(0).getChildNodes());
            Node nValue = nlList.get().item(0);
            if (nValue == null)
                return "";
            return nValue.getNodeValue();

        } catch (Exception exception) {
            log.debug("exception : " + exception);
            return ""; // 해당 Tag 가 없는 경우 catch & return ""
        }
    }


    /**
     * Element 를 Dto 로 반환
     *
     * @param element
     * @return
     * @throws Exception
     */

    private TravelCourseResult getTravelCourseResultFromElement(final Element element) throws Exception {
        return TravelCourseResult.builder()
                .contentid(getTagValue("contentid", element))
                .contenttypeid(getTagValue("contentid", element))
                .distance(getTagValue("distance", element)) // 코스 총거리
                .infocentertourcourse(getTagValue("infocentertourcourse", element)) // 문의 및 안내
                .schedule(getTagValue("schedule", element)) // 코스 일정
                .taketime(getTagValue("taketime", element)) // 코스 총 소요시간
                .theme(getTagValue("theme", element)).build(); // 코스 테마
    }


    // ElementToLodgingDto
    private ApiLodgingDto getLodgingDto(final Element element) throws Exception {
        return ApiLodgingDto.builder()
                .addr1(getTagValue("addr1", element))
                .addr2(getTagValue("addr2", element))
                .areacode(getTagValue("areacode", element))
                .benikia(getTagValue("benikia", element))
                .cat1(getTagValue("cat1", element))
                .cat2(getTagValue("cat1", element))
                .cat3(getTagValue("cat1", element))
                .areacode(getTagValue("areacode", element))
                .contentid(getTagValue("contentid", element))
                .contenttypeid(getTagValue("contenttypeid", element))
                .createdtime(getTagValue("createdtime", element))
                .firstimage(getTagValue("firstimage", element))
                .firstimage2(getTagValue("firstimage2", element))
                .goodstay(getTagValue("goodstay", element))
                .hanok(getTagValue("hanok", element))
                .mapx(getTagValue("mapx", element))
                .mapy(getTagValue("mapy", element))
                .mlevel(getTagValue("mlevel", element))
                .modifiedtime(getTagValue("modifiedtime", element))
                .readcount(getTagValue("readcount", element))
                .tel(getTagValue("tel", element))
                .title(getTagValue("title", element))
                .booktour(getTagValue("booktour", element))
                .sigungucode(getTagValue("sigungucode", element)).build();
    }


    @Override
    public List<TransportationResult> getTransportationList(LanguageType languageType, String contentId) throws Exception {
        // 국문 서비스는 교통 정보를 제공하지 않음
        throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
    }
}
