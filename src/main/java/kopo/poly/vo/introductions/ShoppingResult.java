package kopo.poly.vo.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 38, Multilingual : 79
 * Introduction (소개정보조호 API) 호출 시
 * 쇼핑 정보 조회를 통해 넘어오는 result Type
 */

@Data
@Builder
public class ShoppingResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String fairday; // 장서는 날
    private String infocentershopping; // 문의 및 안내
    private String opendateshopping; // 개장일
    private String opentime; // 영업시간
    private String parkingshopping; // 주차시설
    private String restdateshopping; // 쉬는 날
    private String restroom; // 화장실 설명
    private String saleitem; // 판매 품목
    private String scaleshopping; // 규모
    private String shopguide; // 매장안내



    // 국문만 제공
    private String saleitemcost; // 판매 품목별 가격
    private String chkbabycarriage; // 유모차대여 정보
    private String chkcreditcardculture; // 신용카드가능 정보
    private String chkpetculture; // 동물 가능 여부
    private String culturecenter; // 문화센터 바로가기
}
