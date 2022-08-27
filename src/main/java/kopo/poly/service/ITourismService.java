package kopo.poly.service;

import kopo.poly.enums.LanguageType;
import kopo.poly.vo.ApiLodgingDto;

import java.util.List;

public interface ITourismService {


    // 지역 별 숙박 정보 조회
    List<ApiLodgingDto> getLodgingList(LanguageType languageType, String pageNo, String areaCode, String sigunguCode) throws Exception;
}
