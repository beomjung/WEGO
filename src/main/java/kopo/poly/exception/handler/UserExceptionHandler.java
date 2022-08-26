package kopo.poly.exception.handler;

import kopo.poly.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static kopo.poly.constant.UrlConstants.REDIRECT_URL;

/**
 * Controller 실행 시 같이 실행, 특정 Exception 이 발생 시 호출
 * -> Model 에 ErrorMsg, Url 값 저장 후 redirect page 로 이동 (redirectPage 와 같은 동작)
 */
@Slf4j
@ControllerAdvice
public class UserExceptionHandler {


    @ExceptionHandler({UserException.class}) // UserException 발생 시 실행
    public String handleUserException(final UserException exception, Model model) {
        log.warn("UserException : " + exception.getErrorResult());

        model.addAttribute("msg", exception.getErrorResult().getMessage());
        model.addAttribute("url", exception.getUrl());

        return REDIRECT_URL;
    }
}
