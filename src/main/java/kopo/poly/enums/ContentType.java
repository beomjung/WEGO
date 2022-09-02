package kopo.poly.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContentType {
    TOURIST_DESTINATION("12", "76"), // 관광지
    CULTURAL_FACILITIES("14", "78"), // 문화 시설
    FESTIVAL("15", "85"), // 축제
    LEPORTS("28", "75"), // 레포츠
    LODGING("32", "80"), // 숙박
    SHOPPING("38", "79"), // 쇼핑
    RESTAURANTS("39", "82"), // 음식점
    // 다국어 서비스만 제공
    TRANSPORTATION(null, "77"), // 교통
    // 국문 서비스만 제공
    TRAVEL_COURSE("25", null), // 여행 코스
    ;


    private final String korContentTypeId; // 국문 서비스 ContentType
    private final String multilingualContentTypeId; // 다국어 서비스 ContentType
}
