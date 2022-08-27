package kopo.poly.service;

import kopo.poly.dto.api.ApiLodgingDto;
import kopo.poly.enums.LanguageType;

import java.util.List;

public interface ITourismApiService {


    boolean supports(LanguageType languageType);


    List<ApiLodgingDto> getLodgingList(LanguageType languageType, String pageNo, String areaCode, String sigunguCode) throws Exception;


}
