package kopo.poly.service.impl;

import kopo.poly.enums.ApiServiceType;
import kopo.poly.exception.CustomException;
import kopo.poly.service.ITourismService;
import kopo.poly.vo.ApiAreaBasedDto;
import kopo.poly.vo.ApiKeywordDto;
import kopo.poly.vo.ApiLodgingDto;
import kopo.poly.vo.request.TourismRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;


/**
 * API 호출 후 결과 값이 List 로 넘어옴, LanguageType 필수 -> XmlHandlerService 에서 Exception 발생
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TourismService implements ITourismService {
    private final XmlHandlerService xmlHandlerService;


    /**
     * 숙박 정보 (only) 조회
     *
     * @param request 조회 시 사용되는 Param
     * @return 숙박정보 List (defaultCount : 10)
     * @throws Exception 일치하는 숙박 정보가 없음
     */
    @Override
    public List<ApiLodgingDto> getLodgingList(final TourismRequest request) throws Exception {
        // final LanguageType languageType, final String pageNo, final String areaCode, final String sigunguCode
        log.debug("getLodgingList in " + request.getLanguageType().getLanguageType());
        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .serviceType(ApiServiceType.SEARCH_STAY) // 숙박 정보 조회
                .languageType(request.getLanguageType())
                .arrange(request.getArrange()) // 정렬 기준
                .pageNo(request.getPageNo())  // 페이지 번호
                .cat1(request.getCat1()) // 대분류
                .cat2(request.getCat2()) // 중분류
                .cat3(request.getCat3()) // 소분류
                .contentType(request.getContentType()) // 관광타입
                .areaCode(request.getAreaCode()) // 지역코드
                .sigunguCode(request.getSigunguCode()) // 시군구코드
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
     *
     * @param request languageType, areaCode, sigunguCode (필수) options : { cat1, cat2, cat3, pageNo }
     * @return 관광 정보 List (defaultCount : 10)
     * @throws Exception request 에 대한 관광 정보 없음 || 종료된 서비스
     */

    @Override
    public List<ApiAreaBasedDto> getTourismInfoByArea(TourismRequest request) throws Exception {
        log.debug("getLodgingList in " + request.getLanguageType());


        // Controller 에서 넘어오지 않는 값 (null)의 경우 xmlHandlerService 에서 처리 (전송  X)
        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(request.getLanguageType()) // 언어 정보
                .serviceType(ApiServiceType.SEARCH_ALL_BY_AREA) // 지역 기반으로 조회
                .arrange(request.getArrange()) // 정렬 기준
                .cat1(request.getCat1()) // 대분류
                .cat2(request.getCat2()) // 중분류
                .cat3(request.getCat3()) // 소분류
                .contentType(request.getContentType()) // 관광타입
                .areaCode(request.getAreaCode()) // 지역코드
                .sigunguCode(request.getSigunguCode()).build()); // 시군구코드


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
     *
     * @param request (필수 request) : keyword, languageType (options) : {cat1, cat2, cat3, areaCode, sigunguCode}
     * @return
     * @throws Exception
     */
    @Override
    public List<ApiKeywordDto> getTourismInfoByKeyword(final TourismRequest request) throws Exception {
        log.debug("getTourismInfoByKeyword Start! -> " + request.getLanguageType());

        if (request.getKeyword() == null) { // keyword 없이 로직은 동작하지만 없다면 Exception
            throw new CustomException(HttpStatus.BAD_REQUEST, "KeyWord 를 입력해 주세요.", "/");
        }

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(request.getLanguageType()) // 언어 정보
                .serviceType(ApiServiceType.SEARCH_BY_KEYWORD) // 키워드를 사용하여 조회
                .arrange(request.getArrange())
                .contentType(request.getContentType()) // 관광타입
                .areaCode(request.getAreaCode()) // 지역코드
                .sigunguCode(request.getSigunguCode()) // 시군구코드
                .cat1(request.getCat1()) // 대분류
                .cat2(request.getCat2()) // 중분류
                .cat3(request.getCat3()) // 소분류
                .keyword(request.getKeyword()).build()); // 키워드 (키워드를 사용하여 조회 시 만 전송)


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
