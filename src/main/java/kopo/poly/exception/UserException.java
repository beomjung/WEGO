package kopo.poly.exception;

import kopo.poly.exception.result.UserExceptionResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserException extends RuntimeException {
    private final UserExceptionResult errorResult; // error information
    private final String url; // move to path
}
