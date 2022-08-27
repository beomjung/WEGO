package kopo.poly.exception;

import kopo.poly.exception.result.ApiExceptionResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiException extends RuntimeException {
    private final ApiExceptionResult errorResult; // error information
}
