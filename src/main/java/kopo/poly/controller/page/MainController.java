package kopo.poly.controller.page;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static kopo.poly.constant.UrlConstants.MAIN_URL;

/**
 * Page 이동 Controller
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    @RequestMapping("/main")
    public String mainPage() throws Exception {
        return MAIN_URL;
    }
}
