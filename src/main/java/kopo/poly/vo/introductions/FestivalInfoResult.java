package kopo.poly.vo.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 15, Multilingual : 85
 * Introduction (소개정보조호 API) 호출 시
 * 행사/공연/축제 정보 조회를 통해 넘어오는 result Type
 */
@Data
@Builder
public class FestivalInfoResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String agelimit; // 관람 가능 연령
    private String bookingplace; // 예매체
    private String discountinfofestival; // 할인 정보
    private String eventenddate; // 행사 종료일
    private String eventhomepage; // 행사 홈페이지
    private String eventplace; // 행사 장소
    private String eventstartdate; // 행사 시작일
    private String placeinfo; // 행사장 위치안내
    private String playtime; // 공연시간
    private String program; // 행사 프로그램
    private String spendtimefestival; // 관람 소요시간
    private String sponsor1; // 주최자 정보
    private String sponsor1tel; // 주최자 연락처
    private String sponsor2; // 주관사 정보
    private String sponsor2tel; // 주관사 연력처
    private String subevent; // 부대 행사
    private String usetimefestival; // 이용 요금
    // 국문만 제공
    private String festivalgrade; // 축제 등급
}
