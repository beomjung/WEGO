package kopo.poly.vo.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 39, Multilingual : 82
 * Introduction (소개정보조호 API) 호출 시
 * 음식점 정보 조회를 통해 넘어오는 result Type
 */

@Data
@Builder
public class RestaurantsResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String firstmenu; // 대표 메뉴
    private String infocenterfood; // 문의 및 안내
    private String opendatefood; // 개업일
    private String opentimefood; // 영업시간
    private String parkingfood; // 주차시설
    private String reservationfood; // 예약 안내
    private String restdatefood; // 쉬는날
    private String scalefood; // 규모
    private String seat; // 좌석 수
    private String smoking; // 금연/흡연 여부
    private String treatmenu; // 취급 메뉴
    private String lcnsno; // 인허가 번호

    // 국문만 제공
    private String chkcreditcardfood; // 신용카드 가능 여부
    private String discountinfofood; // 할인 정보
    private String kidsfacility; // 어린이 놀이방
    private String packing; // 포장 가능 여부
}
