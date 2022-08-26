package kopo.poly.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constants About User Service
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConstants {
    public final static String USER_ID_HEADER = "X-USER-ID";
    public final static String USER_NICK_NAME_HEADER = "X-USER-NICKNAME";
    public final static String USER_SESSION_KEY = "USER";
}
