package kopo.poly.exception;

import kopo.poly.exception.result.UserExceptionResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * throw new UserException(UserExceptionResult.{ExceptionType}, "/")
 * -> Exception 발생 후 "/" page 로 이동
 */
@Getter
@RequiredArgsConstructor
public class UserException extends RuntimeException {
    private final UserExceptionResult errorResult; // error information
    private final String url; // move to path
}
