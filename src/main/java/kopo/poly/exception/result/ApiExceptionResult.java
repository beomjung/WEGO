package kopo.poly.exception.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApiExceptionResult {
    // 아직 해당 언어로 지원하지 않는 서비스 호출 시 Exception
    CANNOT_USE_THIS_SERVICE(HttpStatus.BAD_REQUEST, "해당 언어로는 사용할 수 없는 서비스 입니다"),
    RESULT_NOT_FOUND(HttpStatus.NOT_FOUND, "검색 결과가 없습니다"),

    NOT_FOUND_LANGUAGE_TYPE(HttpStatus.BAD_REQUEST, "언어 정보를 입력해 주세요.")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
