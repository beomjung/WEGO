package kopo.poly.service.impl;

import kopo.poly.enums.LanguageType;
import kopo.poly.service.ITourismService;
import kopo.poly.vo.ApiLodgingDto;
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
        log.debug("findAreaCode in " + languageType);
        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "searchStay")
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
}
