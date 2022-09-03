package kopo.poly.service.impl;

import kopo.poly.enums.ApiServiceType;
import kopo.poly.enums.ContentType;
import kopo.poly.enums.LanguageType;
import kopo.poly.exception.ApiException;
import kopo.poly.exception.result.ApiExceptionResult;
import kopo.poly.service.ITourismDetailsService;
import kopo.poly.vo.introductions.*;
import kopo.poly.vo.request.TourismRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourismDetailsService implements ITourismDetailsService {
    private final XmlHandlerService xmlHandlerService;


    /**
     * 관광지 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 관광지 고유 번호
     * @return 관광지 상세 정보 (count : 1)
     * @throws ApiException 일치하는 관광지 정보가 없을 경우
     */
    @Override
    // 언어 + 관광지 번호로 Cache 에 저장
    @Cacheable(cacheNames = "TouristDestination", key = "#languageType.languageType + #contentId")
    public TouristDestinationResult getTouristDestinationDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getTouristDestinationList : " + languageType.getLanguageType());

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType) // Controller 에서 넘어온 서비스 언어 --> ex.) ENG, KOR (필수)
                .contentId(contentId) // 관광정보 고유 번호 --> ex.) 1234567 (필수)
                .serviceType(ApiServiceType.SEARCH_DETAIL) // 서비스 EndPoint 전송 시 알맞은 서비스 EndPoint 설정
                .contentType(ContentType.TOURIST_DESTINATION).build()); // ContentType, 서비스 언어에 맞는 ContentType 정보
        // API 호출 후 *.XML 파일에서 items (main Info) 추출
        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        // 결과가 0개, 없다면 Exception
        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }
        // 단일 조회 -> 반복문을 실행해도 value = 1 or 0 개
        Element element = (Element) items.item(0);

        // getting Dto From Element
        return xmlHandlerService.getTouristDestinationResultFromElement(element);
    }


    /**
     * 축제 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 축제 정보 고유 번호
     * @return 축제 상세 정보 (count : 1)
     * @throws ApiException 일치하는 축제 정보가 없을 경우
     */
    @Override
    @Cacheable(cacheNames = "FestivalInfo", key = "#languageType.languageType + #contentId")
    public FestivalInfoResult getFestivalDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getFestivalInfoList : " + languageType.getLanguageType());

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.FESTIVAL).build());


        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getFestivalInfoResultFromElement(element);
    }

    /**
     * 문화시설 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 고유 번호
     * @return 문화시설 상세 정보 (count : 1)
     * @throws ApiException 일치하는 문화시설 정보가 없을 경우
     */
    @Override
    @Cacheable(cacheNames = "CulturalFacilities", key = "#languageType.languageType + #contentId")
    public CulturalFacilitiesResult getCulturalFacilitiesDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLeportsList : " + languageType.getLanguageType());

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.CULTURAL_FACILITIES).build());

        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getCulturalFacilitiesResultFromElement(element);
    }


    /**
     * 레포츠 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 레포츠 고유 번호
     * @return 레포츠 상세 정보 (count : 1)
     * @throws ApiException 일치하는 레포츠 정보가 없을 경우
     */
    @Override
    @Cacheable(cacheNames = "Leports", key = "#languageType.languageType + #contentId")
    public LeportsResult getLeportsDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLeportsList : " + languageType.getLanguageType());

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.LEPORTS).build());


        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getLeportsResultFromElement(element);
    }


    /**
     * 숙박 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 숙박 고유 번호
     * @return 숙박 상세 정보 (count : 1)
     * @throws ApiException 일치하는 숙박 정보가 없을 경우
     */
    @Override
    @Cacheable(cacheNames = "Lodging", key = "#languageType.languageType + #contentId")
    public LodgingResult getLodgingDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLodgingList : " + languageType.getLanguageType());

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.LODGING).build());


        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getLodgingResultFromElement(element);
    }


    /**
     * 음식점 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 음식점 고유 번호
     * @return 음식점 상세 정보 (count : 1)
     * @throws ApiException 일치하는 음식점 정보가 없을 경우
     */
    @Override
    @Cacheable(cacheNames = "Restaurants", key = "#languageType.languageType + #contentId")
    public RestaurantsResult getRestaurantDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getRestaurantsList : " + languageType.getLanguageType());

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.RESTAURANTS).build());


        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getRestaurantsResultFromElement(element);
    }


    /**
     * 쇼핑 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 쇼핑 정보 고유 번호
     * @return 쇼핑 상세 정보 (count : 1)
     * @throws ApiException 일치하는 쇼핑 정보가 없을 경우
     */
    @Override
    @Cacheable(cacheNames = "Shopping", key = "#languageType.languageType + #contentId")
    public ShoppingResult getShoppingDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getShoppingList : " + languageType.getLanguageType());

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.SHOPPING).build());


        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getShoppingResultFromElement(element);
    }

    // ------------------------------------------ 다국어 또는 국문 서비스 중 한 곳만 요청 가능한 Method


    /**
     * 여행 코스 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 여행코스 고유 번호
     * @return 여행코스 상세 정보 (count : 1)
     * @throws ApiException 일치하는 여행코스 정보가 없을 경우
     * @throws ApiException 국문 (KOR)이 아닌 다른 언어로 요청 시
     */
    @Override
    @Cacheable(cacheNames = "TravelCourse", key = "#languageType.languageType + #contentId")
    public TravelCourseResult getTravelCourseDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getTravelCourseList : " + languageType.getLanguageType());

        if (languageType != LanguageType.KOR) { // 국문 서비스만 제공
            throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
        }
        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.TRAVEL_COURSE).build());



        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getTravelCourseResultFromElement(element);
    }

    /**
     * 교통 정보 조회
     * @param languageType 데이터 언어
     * @param contentId 교통 정보 고유 번호
     * @return 교통 정보 상세 정보 (count : 1)
     * @throws ApiException 일치하는 교통 정보가 없을 경우
     * @throws ApiException 국문 (KOR)으로 요청 시
     */
    @Override
    @Cacheable(cacheNames = "Transportation", key = "#languageType.languageType + #contentId")
    public TransportationResult getTransportationDetails(
            final LanguageType languageType, final String contentId) throws Exception {
        log.info("getTransportationList : " + languageType.getLanguageType());

        if (languageType == LanguageType.KOR) { // 국문 서비스는 제공하지 않음
            throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
        }

        final URI uri = xmlHandlerService.getUri(TourismRequest.builder()
                .languageType(languageType)
                .contentId(contentId)
                .serviceType(ApiServiceType.SEARCH_DETAIL)
                .contentType(ContentType.TRANSPORTATION).build());

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getTransportationResultFromElement(element);
    }
}
