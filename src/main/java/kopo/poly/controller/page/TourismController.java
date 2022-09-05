package kopo.poly.controller.page;

import kopo.poly.service.ITourismService;
import kopo.poly.vo.ApiAreaBasedDto;
import kopo.poly.vo.request.TourismRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static kopo.poly.constant.UrlConstants.MAIN_URL;


/**
 * 관광 정보 API 호출 후 Page 이동 AJAX 호출 불가능
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class TourismController {
    private final ITourismService tourismService;


    /**
     * contentType && areaCode 를 사용하여 관광 정보 조회 (지역 기반 API 호출 Service 활용)
     * @param request 필수 : {languageType, areaCode, contentType}
     * @param model 조회된 관광 정보를 view 로 전송 (key : areaBaseDtoList, value : List<ApiAreaBasedDto>)
     * @return
     * @throws Exception
     */
    @GetMapping("/search")
    public ResponseEntity<List<ApiAreaBasedDto>> searchTourismInformation(final TourismRequest request, Model model) throws Exception {
        log.info("searchTourismInformation Start");

        final List<ApiAreaBasedDto> result = tourismService.getTourismInfoByArea(request);

        log.info("result Count : " + result.size());

        model.addAttribute("areaBasedDtoList", result);

        return ResponseEntity.ok().body(result);


    }
}
