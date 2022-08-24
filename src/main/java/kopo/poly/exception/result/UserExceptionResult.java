package kopo.poly.exception.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserExceptionResult {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자 정보를 찾을 수 없습니다"),
    DUPLICATED_USER_ID_REGISTER(HttpStatus.BAD_REQUEST, "중복된 사용자 아이디 입니다."),
    DUPLICATED_USER_NICKNAME_REGISTER(HttpStatus.BAD_REQUEST, "중복된 사용자 닉네임 입니다."),
    USER_PASSWORD_NOT_MATCHES(HttpStatus.BAD_REQUEST, "비밀번호를 확인해 주세요."),

    ;


    private final HttpStatus httpStatus; // Status About Error
    private final String message; // message

}
