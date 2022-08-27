package kopo.poly.service.impl;

import kopo.poly.dto.api.LodgingDto;
import kopo.poly.dto.api.introductions.IntroductionLodgingDto;
import kopo.poly.enums.LanguageType;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class KorTourismApiService implements ITourismApiService {
    private final DocumentBuilder documentBuilder;
    private final Environment env;

    @Override
    public boolean supports(LanguageType languageType) {
        return languageType == LanguageType.KOR;
    }

    /**
     * 숙박 정보 조회 (searchStay)
     *
     * @param pageNo       PageNo
     * @param areaCode     지역 코드
     * @param sigunguCode  시군구 코드
     * @return List<LodgingDto> 언어에 맞는 숙박 정보 List
     * @throws Exception
     */
    @Override
    // KOR1 이름으로 Lodging Cache 에 저장 요청 시 KOR1이 있다면 로직을 실행하지 않고 Cache 정보를 return
    @Cacheable(cacheNames = "KorLodging")
    public List<LodgingDto> getLodgingList(
            final LanguageType languageType, final String pageNo, final String areaCode, final String sigunguCode)
            throws Exception {
        log.debug("findAreaCode in " + LanguageType.KOR);
        final URI uri = URI.create(getUri(languageType, "searchStay")
                + "&areaCode=" + areaCode
                + "&sigunguCode=" + sigunguCode
                + "&pageNo=" + pageNo);

        log.info("uri : " + uri);

        // XML 처리
        Document doc = documentBuilder.parse(String.valueOf(uri));
        NodeList items = doc.getElementsByTagName("item");

        List<LodgingDto> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(getLodgingDto(element));
            }
        }
        return result;
    }


    // LanguageType 및 Service 이름을 받아서 Uri return
    private URI getUri(LanguageType languageType, String serviceName) throws URISyntaxException {
        return new URI("https://api.visitkorea.or.kr/openapi/service/rest/"+ languageType.getLanguageType() +"/"
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


    // ElementToLodgingDto
    private LodgingDto getLodgingDto(final Element element) throws Exception {
        return LodgingDto.builder()
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
}
