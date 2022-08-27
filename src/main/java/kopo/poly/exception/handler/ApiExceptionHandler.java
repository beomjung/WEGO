package kopo.poly.exception.handler;

import kopo.poly.exception.ApiException;
import kopo.poly.exception.ErrorResponse;
import kopo.poly.exception.UserException;
import kopo.poly.exception.result.ApiExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static kopo.poly.constant.UrlConstants.REDIRECT_URL;


/**
 * API 호출 시 발생하는 Exception 처리
 */
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({ApiException.class}) // ApiException 발생 시 실행
    public ResponseEntity<ErrorResponse> handleApiException(final ApiException exception) {
        log.warn("ApiException : " + exception);

        return this.makeErrorResponseEntity(exception.getErrorResult());
    }

    private ResponseEntity<ErrorResponse> makeErrorResponseEntity(final ApiExceptionResult errorResult) {
        return ResponseEntity.status(errorResult.getHttpStatus())
                .body(new ErrorResponse(errorResult.name(), errorResult.getMessage()));
    }
}
