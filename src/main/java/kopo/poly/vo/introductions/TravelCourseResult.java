package kopo.poly.vo.introductions;

import lombok.Builder;
import lombok.Data;

/**
 * - ContentTypeId
 * KOR : 25 국문만 서비스 제공
 * Introduction (소개정보조호 API) 호출 시
 * 여행코스 조회를 통해 넘어오는 result Type
 */

@Data
@Builder
public class TravelCourseResult {
    private String contentid; // 기본 응답
    private String contenttypeid; // 기본 응답
    private String distance; // 코스 총거리
    private String infocentertourcourse; // 문의 및 안내
    private String schedule; // 코스 일정
    private String taketime; // 코스 총 소요시간
    private String theme; // 코스 테마
}
