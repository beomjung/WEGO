package kopo.poly.service.impl;

import kopo.poly.dto.api.LodgingDto;
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
    public List<LodgingDto> getLodgingList(
            final LanguageType languageType, final String pageNo, final String areaCode, final String sigunguCode) throws Exception {
        log.debug("findAreaCode in " + languageType);
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


    private URI getUri(LanguageType languageType, String serviceName) throws URISyntaxException {
        return new URI("https://api.visitkorea.or.kr/openapi/service/rest/"+ languageType.getLanguageType() +"/"
                + serviceName + "?"
                + "MobileOS=ETC" // 필수
                + "&MobileApp=AppTest" // 필수
                + "&serviceKey=" + env.getProperty("tourism.key"));
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

    // 숙박 정보 조회 Element 정보를 Dto 로 변환하는 Method
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
