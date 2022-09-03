package kopo.poly.service.impl;

import kopo.poly.enums.ApiServiceType;
import kopo.poly.enums.ContentType;
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
    @Cacheable(cacheNames = "TouristDestination", key = "#languageType.languageType + #contentId")
    public TouristDestinationResult getTouristDestinationDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getTouristDestinationList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.TOURIST_DESTINATION)
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
    @Cacheable(cacheNames = "FestivalInfo", key = "#languageType.languageType + #contentId")
    public FestivalInfoResult getFestivalDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getFestivalInfoList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.FESTIVAL)
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
    @Cacheable(cacheNames = "CulturalFacilities", key = "#languageType.languageType + #contentId")
    public CulturalFacilitiesResult getCulturalFacilitiesDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLeportsList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.CULTURAL_FACILITIES)
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
    @Cacheable(cacheNames = "Leports", key = "#languageType.languageType + #contentId")
    public LeportsResult getLeportsDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLeportsList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.LEPORTS)
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
    @Cacheable(cacheNames = "Lodging", key = "#languageType.languageType + #contentId")
    public LodgingResult getLodgingDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getLodgingList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.LODGING)
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
    @Cacheable(cacheNames = "Restaurants", key = "#languageType.languageType + #contentId")
    public RestaurantsResult getRestaurantDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getRestaurantsList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.RESTAURANTS)
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
    @Cacheable(cacheNames = "Shopping", key = "#languageType.languageType + #contentId")
    public ShoppingResult getShoppingDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getShoppingList : " + languageType.getLanguageType());

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.SHOPPING)
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
    @Cacheable(cacheNames = "TravelCourse", key = "#languageType.languageType + #contentId")
    public TravelCourseResult getTravelCourseDetails(LanguageType languageType, String contentId) throws Exception {
        log.info("getTravelCourseList : " + languageType.getLanguageType());

        if (languageType != LanguageType.KOR) { // 국문 서비스만 제공
            throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
        }
        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.TRAVEL_COURSE)
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
    @Cacheable(cacheNames = "Transportation", key = "#languageType.languageType + #contentId")
    public TransportationResult getTransportationDetails(
            final LanguageType languageType, final String contentId) throws Exception {
        log.info("getTransportationList : " + languageType.getLanguageType());

        if (languageType == LanguageType.KOR) { // 국문 서비스는 제공하지 않음
            throw new ApiException(ApiExceptionResult.CANNOT_USE_THIS_SERVICE);
        }

        final URI uri = URI.create(xmlHandlerService.getUri(languageType, ApiServiceType.SEARCH_DETAIL)
                + "&contentTypeId=" + getContentTypeId(languageType, ContentType.TRANSPORTATION)
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
     */
    private String getContentTypeId(final LanguageType languageType, final ContentType contentTypeName) throws Exception {
        if (languageType == LanguageType.KOR) {
            return korContentTypeId.get(contentTypeName);
        } else {
            return multilingualContentTypeId.get(contentTypeName);
        }
    }


    /**
     * ContentTypeId Map
     */
    private final Map<ContentType, String> multilingualContentTypeId = new HashMap<ContentType, String>() {
        {
            put(ContentType.TOURIST_DESTINATION, ContentType.TOURIST_DESTINATION.getMultilingualContentTypeId()); // 관광지
            put(ContentType.CULTURAL_FACILITIES, ContentType.CULTURAL_FACILITIES.getMultilingualContentTypeId()); // 문화 시설
            put(ContentType.FESTIVAL, ContentType.FESTIVAL.getMultilingualContentTypeId()); // 축제
            put(ContentType.LEPORTS, ContentType.LEPORTS.getMultilingualContentTypeId()); // 레포츠
            put(ContentType.LODGING, ContentType.LODGING.getMultilingualContentTypeId()); // 숙박
            put(ContentType.SHOPPING, ContentType.SHOPPING.getMultilingualContentTypeId()); // 쇼핑
            put(ContentType.RESTAURANTS, ContentType.RESTAURANTS.getMultilingualContentTypeId()); // 음식점
            put(ContentType.TRANSPORTATION, ContentType.TRANSPORTATION.getMultilingualContentTypeId()); // only Multilingual 교통
        }
    };

    private final Map<ContentType, String> korContentTypeId = new HashMap<ContentType, String>() {
        {
            put(ContentType.TOURIST_DESTINATION, ContentType.TOURIST_DESTINATION.getKorContentTypeId()); // 관광지
            put(ContentType.CULTURAL_FACILITIES, ContentType.CULTURAL_FACILITIES.getKorContentTypeId()); // 문화 시설
            put(ContentType.FESTIVAL, ContentType.FESTIVAL.getKorContentTypeId()); // 축제
            put(ContentType.LEPORTS, ContentType.LEPORTS.getKorContentTypeId()); // 레포츠
            put(ContentType.LODGING, ContentType.LODGING.getKorContentTypeId()); // 숙박
            put(ContentType.SHOPPING, ContentType.SHOPPING.getKorContentTypeId()); // 쇼핑
            put(ContentType.RESTAURANTS, ContentType.RESTAURANTS.getKorContentTypeId()); // 음식점
            put(ContentType.TRAVEL_COURSE, ContentType.TRAVEL_COURSE.getKorContentTypeId()); // only KOR 여행 코스
        }
    };
}
