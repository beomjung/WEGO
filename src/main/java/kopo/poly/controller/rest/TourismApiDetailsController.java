package kopo.poly.controller.rest;

import kopo.poly.enums.LanguageType;
import kopo.poly.service.ITourismDetailsService;
import kopo.poly.vo.introductions.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static kopo.poly.constant.ApiConstants.LANGUAGE_TYPE_HEADER;

/**
 * ApiDetails 처리 contentId 값을 기준으로 상세 소개 정보 확인
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class TourismApiDetailsController {

    private final ITourismDetailsService tourismDetailsService;

    /**
     * 관광지 정보 조회
     *
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/tourist-destination/{contentId}")
    public ResponseEntity<TouristDestinationResult> getTouristDestination(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getTouristDestinationDetails(languageType, contentId));
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
    public ResponseEntity<CulturalFacilitiesResult> getCulturalFacilities(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {


        return ResponseEntity.ok().body(tourismDetailsService.getCulturalFacilitiesDetails(languageType, contentId));
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
    public ResponseEntity<FestivalInfoResult> getFestivalInfo(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getFestivalDetails(languageType, contentId));
    }

    /**
     * 레포츠 정보 조회
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/leports/{contentId}")
    public ResponseEntity<LeportsResult> getLeports(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getLeportsDetails(languageType, contentId));
    }

    /**
     * 쇼핑 정보 조회
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/shopping/{contentId}")
    public ResponseEntity<ShoppingResult> getShopping(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getShoppingDetails(languageType, contentId));
    }


    /**
     * 음식점 정보 조회
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/restaurants/{contentId}")
    public ResponseEntity<RestaurantsResult> getRestaurants(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getRestaurantDetails(languageType, contentId));
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
    public ResponseEntity<TransportationResult> getTransportation(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getTransportationDetails(languageType, contentId));
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
    public ResponseEntity<TravelCourseResult> getTravelCourse(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getTravelCourseDetails(languageType, contentId));
    }
}
