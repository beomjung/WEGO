package kopo.poly.exception.handler;

import kopo.poly.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static kopo.poly.constant.MainConstants.REDIRECT_PAGE;

@Slf4j
@ControllerAdvice
public class UserExceptionHandler {


    @ExceptionHandler({UserException.class}) // UserException 발생 시 실행
    public String handleUserException(final UserException exception, Model model) {
        log.warn("UserException : " + exception.getErrorResult());

        model.addAttribute("msg", exception.getErrorResult().getMessage());
        model.addAttribute("url", exception.getUrl());

        return REDIRECT_PAGE;
    }
}
