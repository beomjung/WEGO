package kopo.poly.service.impl;

import kopo.poly.enums.LanguageType;
import kopo.poly.exception.ApiException;
import kopo.poly.exception.result.ApiExceptionResult;
import kopo.poly.service.ITourismDetailsService;
import kopo.poly.vo.introductions.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourismDetailsService implements ITourismDetailsService {
    private final XmlHandlerService xmlHandlerService;


    // 관광지 정보 조회
    @Override
    @Cacheable(cacheNames = "MultilingualTouristDestination")
    public TouristDestinationResult getTouristDestinationDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getTouristDestinationList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "TouristDestination")
                + "&contentId=" + contentId);

        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getTouristDestinationResultFromElement(element);
    }


    // 축제 정보 조회
    @Override
    public FestivalInfoResult getFestivalDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getFestivalInfoList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "Festival")
                + "&contentId=" + contentId);

        log.info("URI : " + uri);


        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getFestivalInfoResultFromElement(element);
    }

    // 문화시설 정보 조회
    @Override
    public CulturalFacilitiesResult getCulturalFacilitiesDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLeportsList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "CulturalFacilities")
                + "&contentId=" + contentId);

        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getCulturalFacilitiesResultFromElement(element);
    }


    // 레포츠 정보 조회
    @Override
    public LeportsResult getLeportsDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLeportsList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "Leports")
                + "&contentId=" + contentId);

        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getLeportsResultFromElement(element);
    }


    // 숙박 정보 조회
    @Override
    public LodgingResult getLodgingDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLodgingList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "Lodging")
                + "&contentId=" + contentId);

        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getLodgingResultFromElement(element);
    }


    // 음식점 정보 조회
    @Override
    public RestaurantsResult getRestaurantDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getRestaurantsList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "Restaurants")
                + "&contentId=" + contentId);

        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getRestaurantsResultFromElement(element);
    }


    // 쇼핑 정보 조회
    @Override
    public ShoppingResult getShoppingDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getShoppingList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "Shopping")
                + "&contentId=" + contentId);

        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getShoppingResultFromElement(element);
    }

    // ------------------------------------------ 다국어 또는 국문 서비스 중 한 곳만 요청 가능한 Method


    // 여행 코스 정보 조회
    @Override
    public TravelCourseResult getTravelCourseDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getTravelCourseList : " + languageType.getLanguageType());

        if (languageType != LanguageType.KOR) { // 국문 서비스만 제공
            throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
        }
        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "TravelCourse")
                + "&contentId=" + contentId);

        log.info("uri : " + uri);



        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getTravelCourseResultFromElement(element);
    }

    // 교통 정보 조회
    @Override
    public TransportationResult getTransportationDetails(
            final LanguageType languageType, final String contentId) throws Exception {
        log.info("getTransportationList : " + languageType.getLanguageType());

        if (languageType == LanguageType.KOR) { // 국문 서비스는 제공하지 않음
            throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
        }

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, "detailIntro")
                + "&contentTypeId=" + getContentTypeId(languageType, "Transportation")
                + "&contentId=" + contentId);
        log.info("URI : " + uri);

        final NodeList items = xmlHandlerService.getNoteListFromURI(uri);

        if (items.getLength() == 0 || items.item(0).getNodeType() != Node.ELEMENT_NODE) {
            throw new ApiException(ApiExceptionResult.RESULT_NOT_FOUND);
        }

        Element element = (Element) items.item(0);
        return xmlHandlerService.getTransportationResultFromElement(element);
    }
















    /**
     * KOR 일 경우 KORContentTypeMap else -> multilingualContentTypeMap 에서 ID 값을 가져옴
     * @param languageType
     * @param contentTypeName
     * @return
     * @throws Exception
     */
    private String getContentTypeId(final LanguageType languageType, final String contentTypeName) throws Exception {
        if (languageType == LanguageType.KOR) {
            return korContentTypeId.get(contentTypeName);
        } else {
            return multilingualContentTypeId.get(contentTypeName);
        }
    }


    /**
     * ContentTypeId Map
     */
    private final Map<String, String> multilingualContentTypeId = new HashMap<String, String>() {
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

    private final Map<String, String> korContentTypeId = new HashMap<String, String>() {
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
}
