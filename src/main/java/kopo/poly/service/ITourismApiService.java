package kopo.poly.service;

import kopo.poly.dto.api.ApiLodgingDto;
import kopo.poly.dto.api.introductions.*;
import kopo.poly.enums.LanguageType;

import java.util.List;

public interface ITourismApiService {


    boolean supports(LanguageType languageType);


    // 숙박 정보 조회 Api 호출 및 숙박 정보 List 조회
    List<ApiLodgingDto> getLodgingList(LanguageType languageType, String pageNo, String areaCode, String sigunguCode) throws Exception;

    /**
     * 소개 정보 조회 API 호출
     */

    // 축제 정보 조회
    List<FestivalInfoResult> getFestivalInfoList(LanguageType languageType, String contentId) throws Exception;

    // 문화 시설 정보 조회
    List<CulturalFacilitiesResult> getCulturalFacilitiesList(LanguageType languageType, String contentId) throws Exception;

    // 레포츠 정보 조회
    List<LeportsResult> getLeportsList(LanguageType languageType, String contentId) throws Exception;

    // 숙박 정보 조회
    List<LodgingResult> getLodgingList(LanguageType languageType, String contentId) throws Exception;

    // 음식점 정보 조회
    List<RestaurantsResult> getRestaurantsList(LanguageType languageType, String contentId) throws Exception;

    // 쇼핑 정보 조회
    List<ShoppingResult> getShoppingList(LanguageType languageType, String contentId) throws Exception;

    // 관광지 정보 조회
    List<TouristDestinationResult> getTouristDestinationList(LanguageType languageType, String contentId) throws Exception;

    // 교통 정보 조회
    List<TransportationResult> getTransportationList(LanguageType languageType, String contentId) throws Exception;

    // 여행 코스 정보 조회
    List<TravelCourseResult> getTravelCourseList(LanguageType languageType, String contentId) throws Exception;

}
