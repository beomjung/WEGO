package kopo.poly.controller.rest;

import kopo.poly.dto.api.ApiLodgingDto;
import kopo.poly.dto.api.introductions.*;
import kopo.poly.enums.LanguageType;
import kopo.poly.factory.ApiServiceFactory;
import kopo.poly.service.ITourismApiService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static kopo.poly.constant.ApiConstants.LANGUAGE_TYPE_HEADER;

/**
 * 한국관광공사_영문 관광정보 서비스 Open Api Controller
 */
@RequiredArgsConstructor
@Slf4j
@RestController
public class TourismApiController {
    private final ApiServiceFactory serviceFactory;

    /**
     * 숙박 정보 조회 API 호출
     * @param languageType
     * @param areaCode
     * @param sigunguCode
     * @param pageNo
     * @return
     * @throws Exception
     */
    @GetMapping("/lodgings/{areaCode}/{sigunguCode}/{pageNo}")
    public ResponseEntity<List<ApiLodgingDto>> getLodgingInfo(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType,
            @PathVariable final String areaCode, @PathVariable final String sigunguCode,
            @PathVariable final String pageNo) throws Exception {

        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);


        return ResponseEntity.ok().body(tourismApiService.getLodgingList(languageType, pageNo, areaCode, sigunguCode));

    }

    //
    // ######################### 소개 정보 조회 API 호출 #########################
    //

    /**
     * 관광지 정보 조회
     *
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/tourist-destination/{contentId}")
    public ResponseEntity<List<TouristDestinationResult>> getTouristDestination(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getTouristDestinationList(languageType, contentId));
    }

    /**
     * 문화 시설 조회
     *
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/cultural-facilities/{contentId}")
    public ResponseEntity<List<CulturalFacilitiesResult>> getCulturalFacilities(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getCulturalFacilitiesList(languageType, contentId));
    }


    /**
     * 축제 정보 조회
     *
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/festival/{contentId}")
    public ResponseEntity<List<FestivalInfoResult>> getFestivalInfo(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getFestivalInfoList(languageType, contentId));
    }

    /**
     * 레포츠 정보 조회
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/leports/{contentId}")
    public ResponseEntity<List<LeportsResult>> getLeports(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getLeportsList(languageType, contentId));
    }

    /**
     * 쇼핑 정보 조회
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/shopping/{contentId}")
    public ResponseEntity<List<ShoppingResult>> getShopping(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getShoppingList(languageType, contentId));
    }


    /**
     * 음식점 정보 조회
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/restaurants/{contentId}")
    public ResponseEntity<List<RestaurantsResult>> getRestaurants(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getRestaurantsList(languageType, contentId));
    }



    /**
     * 교통 정보 조회
     *
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception (국문 서비스는 제공하지 않기 때문에 KOR 로 요청 시 Exception)
     */
    @GetMapping("/introductions/transportation/{contentId}")
    public ResponseEntity<List<TransportationResult>> getTransportation(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getTransportationList(languageType, contentId));
    }

    /**
     * 여행 코스 정보 조회
     *
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception (다국어 서비스로 요청 시 Exception)
     */
    @GetMapping("/introductions/travel-course/{contentId}")
    public ResponseEntity<List<TravelCourseResult>> getTravelCourse(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getTravelCourseList(languageType, contentId));
    }
}
