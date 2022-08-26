package kopo.poly.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * CustomException
 */
@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus; // Status
    private final String message; // Error Message
    private final String url; // move to {url}
}
