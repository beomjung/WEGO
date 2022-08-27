package kopo.poly.vo.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 12, Multilingual : 76
 * Introduction (소개정보조호 API) 호출 시
 * 관광지 정보 조회를 통해 넘어오는 result Type
 */

@Data
@Builder
public class TouristDestinationResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String accomcount; // 수용인원
    private String expagerange; // 체험가능 연령
    private String expguide; // 체험 안내
    private String heritage1; // 세계 문화유산 유무
    private String infocenter; // 문의 및 안내
    private String opendate; // 개장일
    private String parking; // 주차시설
    private String restdate; // 쉬는날
    private String useseason; // 이용시기
    private String usetime; // 이용 시간



    // 국문만 제공
    private String heritage2; // 세계 자연유산 유무
    private String heritage3; // 세계 기록유산 유무
    private String chkpet; // 동물 가능 여부
    private String chkcreditcard; // 신용카드 가능 여부
    private String chkbabycarriage; // 유모차 대여 여부

}


