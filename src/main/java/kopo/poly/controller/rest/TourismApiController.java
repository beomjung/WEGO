package kopo.poly.controller.rest;

import kopo.poly.service.ITourismDetailsService;
import kopo.poly.service.ITourismService;
import kopo.poly.vo.*;
import kopo.poly.enums.LanguageType;
import kopo.poly.vo.introductions.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static kopo.poly.constant.ApiConstants.LANGUAGE_TYPE_HEADER;

/**
 * 한국관광공사 관광정보 서비스 Open Api (행사 정보 조회, 숙박 정보 조회, 지역기반 관광 정보 조회, 반복 정보 조회) 등 List 로 넘어오는 Values
 */
@RequiredArgsConstructor
@Slf4j
@RestController
public class TourismApiController {
    private final ITourismService tourismService;

    /**
     * 숙박 정보 조회 API 호출
     * @param languageType 호출 언어
     * @param areaCode 지역 코드
     * @param sigunguCode 시군구 코드
     * @param pageNo 페이지 번호
     * @return
     * @throws Exception
     */
    @GetMapping("/lodgings/{areaCode}/{sigunguCode}/{pageNo}")
    public ResponseEntity<List<ApiLodgingDto>> getLodgingInfo(
            @RequestHeader(LANGUAGE_TYPE_HEADER) final LanguageType languageType,
            @PathVariable final String areaCode, @PathVariable final String sigunguCode,
            @PathVariable final String pageNo) throws Exception {



        return ResponseEntity.ok().body(tourismService.getLodgingList(languageType, pageNo, areaCode, sigunguCode));

    }
}
