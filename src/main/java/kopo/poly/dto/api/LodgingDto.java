package kopo.poly.dto.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LodgingDto {
    /**
     * 숙박 정보 Dto
     */
    private String contentid; // 콘텐츠 아이디
    private String contenttypeid; // 콘텐츠 타입 아이디
    private String addr1; // 주소
    private String addr2; // 상세 주소
    private String areacode; // 지역 코드
    private String benikia; // 베니키아 여부
    private String cat1; // 대분류
    private String cat2; // 중분류
    private String cat3; // 소분류
    private String createdtime; // 등록일
    private String firstimage; // 대표 이미지 원본
    private String firstimage2; // 대표 이미지 썸네일
    private String goodstay; // 굿스테이 여부
    private String hanok; // 한옥 여부
    private String mapx; // GPS X 좌표
    private String mapy; // GPS Y 좌표
    private String mlevel; // Map Level
    private String modifiedtime; // 수정일
    private String readcount; // 조회 수
    private String tel; // 전화번호
    private String title; // 제목
    private String booktour; // 교과서 속 여행지 여부 / 국문만 제공
    private String sigungucode; // 시군구코드
}
