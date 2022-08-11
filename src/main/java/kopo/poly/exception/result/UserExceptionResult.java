package kopo.poly.exception.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserExceptionResult {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    ;


    private final HttpStatus httpStatus; // Status About Error
    private final String message; // message

}
