package kopo.poly.vo.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * Multilingual : 77 다국어만 서비스 제공
 * Introduction (소개정보조호 API) 호출 시
 * 교통 정보 조회를 통해 넘어오는 result Type
 */

@Data
@Builder
public class TransportationResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String chkcreditcardtraffic; // 신용카드가능여부
    private String conven; // 편의시설
    private String disablefacility; // 장애인편의시설
    private String foreignerinfocenter; // 외국인문의 및 안내
    private String infocentertraffic; // 문의 및 안내
    private String mainroute; // 주요 노선
    private String operationtimetraffic; // 운영시간
    private String parkingtraffic; // 주차시설
    private String restroomtraffic; // 화장실
    private String shipinfo; // 여객선정보
}
