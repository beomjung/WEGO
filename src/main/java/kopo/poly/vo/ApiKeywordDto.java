package kopo.poly.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * 키워드를 사용하여 관관정보 조회 시 넘어오는 Values
 */
@Getter
@Builder
public class ApiKeywordDto {
    private String booktour; // KeyWord 조회 시 추가
    private String addr1;
    private String addr2;
    private String areacode;
    private String cat1;
    private String cat2;
    private String cat3;
    private String contentid;
    private String contenttypeid;
    private String createdtime;
    private String firstimage;
    private String firstimage2;
    private String mapx;
    private String mapy;
    private String mlevel;
    private String modifiedtime;
    private String readcount;
    private String sigungucode;
    private String tel;
    private String title;
}
