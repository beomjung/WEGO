package kopo.poly.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiServiceType {
    SEARCH_STAY("searchStay"), // 숙박 정보 조회
    SEARCH_ALL_BY_AREA("areaBasedList"), // 지역기반 관광정보 조회
    SEARCH_DETAIL("detailIntro"), // 상세 정보 조회

    SEARCH_BY_KEYWORD("searchKeyword") // 키워드를 사용하여 관광정보 조회
    ;

    private final String serviceEndPoint; // Service EndPoint
}
