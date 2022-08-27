package kopo.poly.service;

import kopo.poly.enums.LanguageType;
import kopo.poly.vo.introductions.*;

public interface ITourismDetailsService {
    FestivalInfoResult getFestivalDetails(LanguageType languageType, String contentId) throws Exception;

    // 문화 시설 정보 조회
    CulturalFacilitiesResult getCulturalFacilitiesDetails(LanguageType languageType, String contentId) throws Exception;

    // 레포츠 정보 조회
    LeportsResult getLeportsDetails(LanguageType languageType, String contentId) throws Exception;

    // 숙박 정보 조회
    LodgingResult getLodgingDetails(LanguageType languageType, String contentId) throws Exception;

    // 음식점 정보 조회
    RestaurantsResult getRestaurantDetails(LanguageType languageType, String contentId) throws Exception;

    // 쇼핑 정보 조회
    ShoppingResult getShoppingDetails(LanguageType languageType, String contentId) throws Exception;

    // 관광지 정보 조회
    TouristDestinationResult getTouristDestinationDetails(LanguageType languageType, String contentId) throws Exception;

    // 교통 정보 조회
    TransportationResult getTransportationDetails(LanguageType languageType, String contentId) throws Exception;

    // 여행 코스 정보 조회
    TravelCourseResult getTravelCourseDetails(LanguageType languageType, String contentId) throws Exception;
}
