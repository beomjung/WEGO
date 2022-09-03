package kopo.poly.controller.rest;

import kopo.poly.service.ITourismService;
import kopo.poly.vo.*;
import kopo.poly.vo.request.TourismRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


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
     * @param areaCode 지역 코드
     * @param sigunguCode 시군구 코드
     * @param request 요청 Param
     * @return
     * @throws Exception
     */
    @GetMapping("/lodgings/{areaCode}/{sigunguCode}")
    public ResponseEntity<List<ApiLodgingDto>> getLodgingInfo(
            @PathVariable final String areaCode, @PathVariable final String sigunguCode,
            @Valid TourismRequest request) throws Exception {


        return ResponseEntity.ok().body(tourismService.getLodgingList(
                request.getLanguageType(), request.getPageNo(), areaCode, sigunguCode));

    }

    /**
     * 지역을 기반으로 관광 정보 조회 API 호출
     *
     * @param areaCode    지역 코드
     * @param sigunguCode 시군구 코드
     * @param request     추가 정보 (분류 or 정렬) cat1 = 대분류, cat2 = 중분류, cat3 = 소분류 -> cat1 없이 cat2 요청 불가
     * @return
     * @throws Exception
     */
    @GetMapping("/areas/{areaCode}/{sigunguCode}")
    public ResponseEntity<List<ApiAreaBasedDto>> getTourismInfoByArea(
            @PathVariable String areaCode, @PathVariable String sigunguCode,
            @Valid TourismRequest request) throws Exception {
        request.setAreaCode(areaCode);
        request.setSigunguCode(sigunguCode);

        log.info("pageNo : " + request.getPageNo());


        return ResponseEntity.ok().body(tourismService.getTourismInfoByArea(request));
    }
}
