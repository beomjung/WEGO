package kopo.poly.vo.request;

import kopo.poly.enums.ContentType;
import kopo.poly.enums.LanguageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourismRequest {
    @NotNull(message = "cannot be Null ( languageType )")
    private LanguageType languageType; // 언어 설정
    private String pageNo; // PageNo
    private String areaCode; // 지역 번호
    private String sigunguCode; // 시군구 번호
    private String arrange; // 정렬 기준 (?)
    private ContentType contentType; // ContentId (숙박, 축제)
    // --> 대분류 없이 중분류 요청 불가, 중분류 없이 소분류 요청 불가
    private String cat1; // 대분류
    private String cat2; // 중분류
    private String cat3; // 소분류

}
