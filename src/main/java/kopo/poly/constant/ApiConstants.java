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
            put("TouristDestination", "12"); // 관광지
            put("CulturalFacilities", "14"); // 문화 시설
            put("Festival", "15"); // 축제
            put("TravelCourse", "25"); // only KOR 여행 코스
            put("Leports", "28"); // 레포츠
            put("Lodging", "32"); // 숙박
            put("Shopping", "38"); // 쇼핑
            put("Restaurants", "39"); // 음식점
        }
    };

    /**
     * 다국어 서비스에서 사용되는 CONTENT_TYPE_ID
     * + 소개 정보 조회 사용 시 TYPE_ID 에 따라 다른 return type
     */
    private final static Map<String, String> OTHER_CONTENT_TYPE_ID = new HashMap<String, String>() {
        {
            put("TouristDestination", "76"); // 관광지
            put("CulturalFacilities", "78"); // 문화 시설
            put("Festival", "85"); // 축제
            put("Leports", "75"); // 레포츠
            put("Lodging", "80"); // 숙박
            put("Shopping", "79"); // 쇼핑
            put("Restaurants", "82"); // 음식점
            put("Transportation", "77"); // only Multilingual 교통
        }
    };
}
