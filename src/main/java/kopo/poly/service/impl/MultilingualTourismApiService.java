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


/**
 * 다국어 서비스 처리 Service
 * + KOR and Other 서비스의 ContentTypeId 가 다름 추가로 다른 부분 확인 후 서비스 나누기 or 합치기
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MultilingualTourismApiService implements ITourismApiService {

    private final DocumentBuilder documentBuilder;
    private final Environment env;

    private final Map<String, String> CONTENT_TYPE_ID_MAP = new HashMap<String, String>() {
        {
            put("TouristDestination", "76"); // 관광지
            put("CulturalFacilities", "78"); // 문화 시설
            put("Festival", "85"); // 축제
            put("Leports", "75"); // 레포츠
            put("Lodging", "80"); // 숙박
            put("Shopping", "79"); // 쇼핑
            put("Restaurants", "82"); // 음식점
            put("Transportation", "77"); // only Multilingual 교통
        }
    };

    @Override
    public boolean supports(LanguageType languageType) {
        return languageType == LanguageType.ENG
                || languageType == LanguageType.JPN
                || languageType == LanguageType.SPN
                || languageType == LanguageType.RUS
                || languageType == LanguageType.GER;
    }

    @Override
    @Cacheable(cacheNames = "MultilingualLodging")
    public List<ApiLodgingDto> getLodgingList(
            final LanguageType languageType, final String pageNo, final String areaCode, final String sigunguCode) throws Exception {
        log.debug("findAreaCode in " + languageType);
        final URI uri = URI.create(getUri(languageType, "searchStay")
                + "&areaCode=" + areaCode
                + "&sigunguCode=" + sigunguCode
                + "&pageNo=" + pageNo);

        log.info("uri : " + uri);

        // XML 처리
//        Document doc = documentBuilder.parse(String.valueOf(uri));
//        NodeList items = doc.getElementsByTagName("item");
        final NodeList items = getItemsFromURI(uri);

        List<ApiLodgingDto> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(getLodgingDtoFromElement(element));
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


    // 교통 정보 조회
    @Override
    @Cacheable(cacheNames = "MultilingualTransportation")
    public List<TransportationResult> getTransportationList(
            final LanguageType languageType, final String contentId) throws Exception {
        log.info("getTransportationList : " + languageType.getLanguageType());
        final URI uri = URI.create(getUri(languageType, "detailIntro")
        + "&contentTypeId=" + CONTENT_TYPE_ID_MAP.get("Transportation")
        + "&contentId=" + contentId);

        log.info("uri : " + uri);


        final NodeList items = getItemsFromURI(uri);

        List<TransportationResult> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(getTransportationResultFromElement(element));
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


    private URI getUri(LanguageType languageType, String serviceName) throws URISyntaxException {
        return new URI("https://api.visitkorea.or.kr/openapi/service/rest/"+ languageType.getLanguageType() +"/"
                + serviceName + "?"
                + "MobileOS=ETC" // 필수
                + "&MobileApp=AppTest" // 필수
                + "&serviceKey=" + env.getProperty("tourism.key"));
    }



    // URI 를 받아 NodeList (XML) 파일의 응답을 (NodeList) 로 반환
    private NodeList getItemsFromURI(final URI uri) throws Exception {
        Document doc = documentBuilder.parse(String.valueOf(uri));
        NodeList items = doc.getElementsByTagName("item");

        return items;
    }



    // 만약 해당 Tag 에 값이 없을 경우 exception 처리
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
     * @param element
     * @return
     * @throws Exception
     */

    // 숙박 정보 조회 Element 정보를 Dto 로 변환하는 Method
    private ApiLodgingDto getLodgingDtoFromElement(final Element element) throws Exception {
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

    private TransportationResult getTransportationResultFromElement(final Element element) throws Exception {
        return TransportationResult.builder()
                .contenttypeid(getTagValue("contenttypeid", element))
                .contentid(getTagValue("contentid", element))
                .chkcreditcardtraffic(getTagValue("chkcreditcardtraffic", element))
                .conven(getTagValue("conven", element))
                .disablefacility(getTagValue("disablefacility", element))
                .foreignerinfocenter(getTagValue("foreignerinfocenter", element))
                .infocentertraffic(getTagValue("infocentertraffic", element))
                .mainroute(getTagValue("mainroute", element))
                .operationtimetraffic(getTagValue("operationtimetraffic", element))
                .parkingtraffic(getTagValue("parkingtraffic", element))
                .restroomtraffic(getTagValue("restroomtraffic", element))
                .shipinfo(getTagValue("shipinfo", element)).build();

    }
    @Override
    public List<TravelCourseResult> getTravelCourseList(LanguageType languageType, String contentId) throws Exception {
        // 다국어 서비스는 여행 코스 서비스를 제공하지 않음
        throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
    }
}
