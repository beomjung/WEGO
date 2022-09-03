package kopo.poly.service.impl;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import kopo.poly.enums.ApiServiceType;
import kopo.poly.enums.LanguageType;
import kopo.poly.exception.CustomException;
import kopo.poly.service.ITourismService;
import kopo.poly.vo.ApiAreaBasedDto;
import kopo.poly.vo.ApiKeywordDto;
import kopo.poly.vo.ApiLodgingDto;
import kopo.poly.vo.request.TourismRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
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


    /**
     * 지역 정보를 기반으로 숙박 정보 (only) 조회
     * @param languageType 언어 정보 (수정)
     * @param pageNo page 번호 -> 기본적으로 pageNo : 1
     * @param areaCode 지역 번호
     * @param sigunguCode 시군구 번호
     * @return 숙박정보 List
     * @throws Exception 일치하는 숙박 정보가 없음
     */
    @Override
    @Cacheable(cacheNames = "MultilingualLodgingApi")
    public List<ApiLodgingDto> getLodgingList(
            final LanguageType languageType, final String pageNo, final String areaCode, final String sigunguCode) throws Exception {
        log.debug("getLodgingList in " + languageType);
        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .areaCode(areaCode)
                .languageType(languageType)
                .pageNo(pageNo)
                .sigunguCode(sigunguCode)
                .serviceType(ApiServiceType.SEARCH_STAY).build());

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

    /**
     * 지역 정보를 기반으로 관광 정보를 조회
     * @param request
     * @return 관광 정보 List
     * @throws Exception request 에 대한 관광 정보 없음 || 종료된 서비스
     */

    @Override
    public List<ApiAreaBasedDto> getTourismInfoByArea(TourismRequest request) throws Exception {
        log.debug("getLodgingList in " + request.getLanguageType());

        request.setServiceType(ApiServiceType.SEARCH_ALL_BY_AREA);

        final URI uri = xmlHandlerService.getUri(request);


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

    /**
     * 키워드를 사용하여 숙박 정보 조회
     * @param request (필수 request) : keyword, languageType
     * @return
     * @throws Exception
     */
    @Override
    public List<ApiKeywordDto> getTourismInfoByKeyword(final TourismRequest request) throws Exception {
        log.debug("getTourismInfoByKeyword Start! -> " + request.getLanguageType());

        if (request.getKeyword() == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "KeyWord를 입력해 주세요.", "/");
        }

        request.setServiceType(ApiServiceType.SEARCH_BY_KEYWORD);
        final URI uri = xmlHandlerService.getUri(request);


        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);
        List<ApiKeywordDto> result = new LinkedList<>();

        for (int i = 0; i < items.getLength(); i++) {
            final Node item = items.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;
                result.add(xmlHandlerService.getKeywordDtoFromElement(element));
            }

        }
        return result;
    }
}
