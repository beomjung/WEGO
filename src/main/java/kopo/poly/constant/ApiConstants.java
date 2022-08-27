package kopo.poly.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * API Language Constants
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiConstants {
    public final static String LANGUAGE_TYPE_HEADER = "X-LANGUAGE";


    /**
     * 한국어 서비스에서 사용되는 CONTENT_TYPE_ID
     * + 소개 정보 조회 사용 시 TYPE_ID 에 따라 다른 return type
     */
    private final static Map<String, String> KOR_CONTENT_TYPE_ID = new HashMap<String, String>() {
        {
            put("관광지", "12");
            put("문화시설", "14");
            put("공연", "15");
            put("여행코스", "25"); // only KOR
            put("레포츠", "28");
            put("숙박", "32");
            put("쇼핑", "38");
            put("음식점", "39");
        }
    };

    /**
     * 다국어 서비스에서 사용되는 CONTENT_TYPE_ID
     * + 소개 정보 조회 사용 시 TYPE_ID 에 따라 다른 return type
     */
    private final static Map<String, String> OTHER_CONTENT_TYPE_ID = new HashMap<String, String>() {
        {
            put("관광지", "76");
            put("문화시설", "78");
            put("공연", "85");
            put("레포츠", "75");
            put("숙박", "80");
            put("쇼핑", "79");
            put("음식점", "82");
            put("교통", "77"); // only Other
        }
    };
}
