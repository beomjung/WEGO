package kopo.poly.service.impl;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import kopo.poly.enums.ApiServiceType;
import kopo.poly.enums.LanguageType;
import kopo.poly.service.ITourismService;
import kopo.poly.vo.ApiAreaBasedDto;
import kopo.poly.vo.ApiLodgingDto;
import kopo.poly.vo.request.TourismRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TourismService implements ITourismService {
    private final XmlHandlerService xmlHandlerService;

    @Override
    @Cacheable(cacheNames = "MultilingualLodgingApi")
    public List<ApiLodgingDto> getLodgingList(
            final LanguageType languageType, final String pageNo, final String areaCode, final String sigunguCode) throws Exception {
        log.debug("getLodgingList in " + languageType);
        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_STAY)
                + "&areaCode=" + areaCode
                + "&sigunguCode=" + sigunguCode
                + "&pageNo=" + pageNo);

        log.info("uri : " + uri);
        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        List<ApiLodgingDto> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(xmlHandlerService.getLodgingDtoFromElement(element));
            }
        }
        return result;
    }

    @Override
    public List<ApiAreaBasedDto> getTourismInfoByArea(TourismRequest request) throws Exception {
        log.debug("getLodgingList in " + request.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(request.getLanguageType(), ApiServiceType.SEARCH_ALL_BY_AREA)
                + "&areaCode=" + request.getAreaCode()
                + "&sigunguCode=" + request.getSigunguCode()
                + "&arrange=" + request.getArrange()
                + (request.getCat1() != null ? "&cat1=" + request.getCat1() : "")
                + (request.getCat1() != null && request.getCat2() != null ? "&cat2=" + request.getCat2() : "")
                + (request.getCat1() != null && request.getCat2() != null && request.getCat3() != null ? "&cat3=" + request.getCat3() : "")
                + "&pageNo=" + request.getPageNo());

        log.info("uri : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        List<ApiAreaBasedDto> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(xmlHandlerService.getAreaBasedDtoFromElement(element));
            }
        }
        return result;
    }

}
