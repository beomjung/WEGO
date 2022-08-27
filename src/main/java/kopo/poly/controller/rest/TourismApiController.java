package kopo.poly.controller.rest;

import kopo.poly.dto.api.ApiLodgingDto;
import kopo.poly.dto.api.introductions.TransportationResult;
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

    @GetMapping("/lodgings/{areaCode}/{sigunguCode}/{pageNo}")
    public ResponseEntity<List<ApiLodgingDto>> getLodgingInfo(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType,
            @PathVariable final String areaCode, @PathVariable final String sigunguCode,
            @PathVariable final String pageNo) throws Exception {

        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);


        return ResponseEntity.ok().body(tourismApiService.getLodgingList(languageType, pageNo, areaCode, sigunguCode));

    }

    /**
     * 교통 정보 조회
     * @param languageType
     * @param contentId
     * @return
     * @throws Exception (국문 서비스는 제공하지 않기 때문에 KOR 로 요청 시 Exception)
     */
    @GetMapping("/introductions/transportation/{contentId}")
    public ResponseEntity<List<TransportationResult>> getTransportation (
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType, @PathVariable final String contentId)
            throws Exception {
        final ITourismApiService tourismApiService = serviceFactory.findTourismApiService(languageType);

        return ResponseEntity.ok().body(tourismApiService.getTransportationList(languageType, contentId));
    }
}
