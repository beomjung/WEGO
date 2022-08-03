package kopo.poly.exception.handler;

import kopo.poly.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static kopo.poly.constant.MainConstants.REDIRECT_PAGE;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public String handleCustomException(final CustomException exception, Model model) {
        log.warn("CustomException : " + exception.getMessage() + "(" + exception.getHttpStatus() + ")");

        model.addAttribute("msg", exception.getMessage());
        model.addAttribute("url", exception.getUrl());


        return REDIRECT_PAGE;

    }
}
