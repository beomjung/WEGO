package kopo.poly.controller.rest;

import kopo.poly.enums.LanguageType;
import kopo.poly.service.ITourismDetailsService;
import kopo.poly.vo.introductions.*;
import kopo.poly.vo.request.TourismRequest;
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
 // TODO: 2022/09/03 EndPoint 하나로 합쳐도 됨
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class TourismApiDetailsController {

    private final ITourismDetailsService tourismDetailsService;

    /**
     * 관광지 정보 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/tourist-destination/{contentId}")
    public ResponseEntity<TouristDestinationResult> getTouristDestination(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {

        return ResponseEntity.ok().body(
                tourismDetailsService.getTouristDestinationDetails(request.getLanguageType(), contentId));
    }

    /**
     * 문화 시설 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/cultural-facilities/{contentId}")
    public ResponseEntity<CulturalFacilitiesResult> getCulturalFacilities(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {


        return ResponseEntity.ok().body(
                tourismDetailsService.getCulturalFacilitiesDetails(request.getLanguageType(), contentId));
    }


    /**
     * 축제 정보 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/festival/{contentId}")
    public ResponseEntity<FestivalInfoResult> getFestivalInfo(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {

        return ResponseEntity.ok().body(
                tourismDetailsService.getFestivalDetails(request.getLanguageType(), contentId));
    }

    /**
     * 레포츠 정보 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/leports/{contentId}")
    public ResponseEntity<LeportsResult> getLeports(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getLeportsDetails(request.getLanguageType(), contentId));
    }

    /**
     * 쇼핑 정보 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/shopping/{contentId}")
    public ResponseEntity<ShoppingResult> getShopping(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {

        return ResponseEntity.ok().body(tourismDetailsService.getShoppingDetails(request.getLanguageType(), contentId));
    }


    /**
     * 음식점 정보 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception
     */
    @GetMapping("/introductions/restaurants/{contentId}")
    public ResponseEntity<RestaurantsResult> getRestaurants(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {

        return ResponseEntity.ok().body(
                tourismDetailsService.getRestaurantDetails(request.getLanguageType(), contentId));
    }


    /**
     * 교통 정보 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception 다국어 서비스만 정보를 제공하기 때문에 KOR 로 요청 시 Exception
     */
    @GetMapping("/introductions/transportation/{contentId}")
    public ResponseEntity<TransportationResult> getTransportation(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {

        return ResponseEntity.ok().body(
                tourismDetailsService.getTransportationDetails(
                        request.getLanguageType(), contentId));
    }

    /**
     * 여행 코스 정보 조회
     * @param contentId 관광 정보 고유 번호
     * @param request LanguageType
     * @return
     * @throws Exception 국문 서비스만 제공하기 때문에 KOR 외 서비스로 요청 시 Exception
     */
    @GetMapping("/introductions/travel-course/{contentId}")
    public ResponseEntity<TravelCourseResult> getTravelCourse(
            @PathVariable final String contentId, final TourismRequest request) throws Exception {

        return ResponseEntity.ok().body(
                tourismDetailsService.getTravelCourseDetails(request.getLanguageType(), contentId));
    }
}
