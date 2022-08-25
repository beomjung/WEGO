package kopo.poly.controller;

import kopo.poly.dto.UserDto;
import kopo.poly.service.IUserService;
import kopo.poly.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.awt.*;

import static kopo.poly.constant.UrlConstants.*;
import static kopo.poly.constant.UserConstants.USER_SESSION_KEY;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    /**
     * 사용자 회원가입
     *
     * @param request (UserDto)
     * @param model
     * @return
     * @throws Exception
     */
    @PostMapping("/users")
    public String saveUserInfo(final HttpServletRequest request, Model model) throws Exception {
        log.debug(this.getClass().getName() + "사용자 회원가입 시작");
        // TODO: 2022/08/24 사용자 정보 유효성 검사 in 컨트롤러 or @Validated or JSP 에서 처리하기

        final UserDto result = userService.saveUserInfo(UserDto.builder()
                .userId(String.valueOf(request.getParameter("userId")))
                .userPassword(String.valueOf(request.getParameter("userPassword")))
                .userEmail(String.valueOf(request.getParameter("userEmail")))
                .userNickname(String.valueOf(request.getParameter("userNickname")))
                .userName(String.valueOf(request.getParameter("userName")))
                .userGender(String.valueOf(request.getParameter("userGender")))
                .userAge(Integer.parseInt(request.getParameter("userAge")))
                .userAddress(String.valueOf(request.getParameter("userAddress"))).build());

        model.addAttribute("msg", result.getUserId() + "님 회원가입을 축하드립니다");
        model.addAttribute("url", INDEX_URL);

        return REDIRECT_URL;
    }

    /**
     * 사용자 로그인
     *
     * @param request (userId, userPassword)
     * @param model
     * @param session (로그인 성공 시 userDto)
     * @return "/mainPage 이동"
     * @throws Exception
     */
    @PostMapping(value = "/users/login")
    public String userLogin(final HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.debug("사용자 로그인 실행");

        log.info("userId : " + request.getParameter("userId"));

        final UserDto result = userService.userLogin(UserDto.builder()
                .userId(String.valueOf(request.getParameter("userId")))
                .userPassword(String.valueOf(request.getParameter("userPassword"))).build());

        session.setAttribute(USER_SESSION_KEY, result);

        model.addAttribute("msg", result.getUserId() + "님 환영합니다");
        model.addAttribute("url", MAIN_URL);


        return REDIRECT_URL;
    }

    /**
     * 사용자 정보 변경
     *
     * @param request
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @PatchMapping("/users")
    public String updateUserInfo(final HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.debug("사용자 정보 변경");

        // session 정보 set in request
        final UserDto sessionUserDto = (UserDto) session.getAttribute(USER_SESSION_KEY);

        final UserDto result = userService.updateUserInfo(UserDto.builder()
                .userId(sessionUserDto.getUserId())
                .userPassword(EncryptUtil.encHashSHA256(String.valueOf(request.getParameter("userPassword"))))
                // Request 에서 받아오는 값
                .userAge(Integer.parseInt(String.valueOf(request.getParameter("userAge"))))
                .userAddress(String.valueOf(request.getParameter("userAddress")))
                .userGender(String.valueOf(request.getParameter("userGender"))).build());


        model.addAttribute("msg", "사용자 정보 변경 완료");
        model.addAttribute("url", MAIN_URL);

        session.removeAttribute(USER_SESSION_KEY);
        session.setAttribute(USER_SESSION_KEY, result); // session Update


        return REDIRECT_URL;

    }
}
