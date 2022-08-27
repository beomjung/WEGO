package kopo.poly.vo.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 32, Multilingual : 80
 * Introduction (소개정보조호 API) 호출 시
 * 숙박 정보 조회를 통해 넘어오는 result Type
 */
@Data
@Builder
public class LodgingResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String accomcountlodging; // 수용 가능인원
    private String benikia; // 베니키아 여부
    private String checkintime; // 입실 시간
    private String checkouttime; // 퇴실 시간
    private String chkcooking; // 취사 여부
    private String foodplace; // 식음료장
    private String goodstay; // 굿스테이 여부
    private String hanok; // 한옥 여부
    private String infocenterlodging; // 문의 및 안내
    private String parkinglodging; // 주차 시설
    private String pickup; // 픽업 서비스
    private String roomcount; // 객실 수
    private String reservationlodging; // 예약 안내
    private String reservationurl; // 예약안내 홈페이지
    private String roomtype; // 객실 유형
    private String scalelodging; // 규모
    private String subfacility; // 부대 시설
    // 국문만 제공
    private String barbecue; // 바비큐장 여부
    private String beauty; // 뷰티시설 정보
    private String beverage; // 식음료장 여부
    private String bicycle; // 자전거 대여 여부
    private String campfire; // 캠프파이어 여부
    private String fitness; // 휘트니스 센터 여부
    private String karaoke; // 노래방 여부
    private String publicbath; // 공용 샤워실 여부
    private String publicpc; // 공요 PC실 여부
    private String sauna; // 사우나실 여부
}
