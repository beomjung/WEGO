package kopo.poly.dto.api.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 14, Multilingual : 78
 * Introduction (소개정보조호 API) 호출 시
 * 문화 시설 조회를 통해 넘어오는 result Type
 */
@Data
@Builder
public class CulturalFacilitiesResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String accomcountculture; // 수용인원
    private String infocenterculture; // 문의 및 안내
    private String parkingculture; // 주차 시설
    private String parkingfee; // 주차 요금
    private String restdateculture; // 쉬는날
    private String usefee; // 이용요금
    private String usetimeculture; // 이용 시간
    private String scale; // 규모
    private String spendtime; // 관람 소요 시간

    // 국문만 제공
    private String chkbabycarriage; // 유모차대여 정보
    private String chkcreditcardculture; // 신용카드가능 정보
    private String chkpetculture; // 동물 가능 여부
    private String discountinfo; // 할인 정보


}
