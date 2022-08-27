package kopo.poly.dto.api.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 28, Multilingual : 75
 * Introduction (소개정보조호 API) 호출 시
 * 레포츠 정보 조회를 통해 넘어오는 result Type
 */
@Data
@Builder
public class LeportsResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String accomcountleports; // 수용 인원
    private String expagerangeleports; // 체험 가능연령
    private String infocenterleports; // 문의 및 안내
    private String openperiod; // 개장시간
    private String parkingfeeleports; // 주차요금
    private String parkingleports; // 주차시설
    private String reservation; // 예약안내
    private String restdateleports; // 쉬는 날
    private String scaleleports; // 규모
    private String usefeeleports; // 입장료
    private String usetimeleports; // 이용시간
    // 국문만 제공
    private String chkbabycarriage; // 유모차대여 정보
    private String chkcreditcardculture; // 신용카드가능 정보
    private String chkpetculture; // 동물 가능 여부

}
