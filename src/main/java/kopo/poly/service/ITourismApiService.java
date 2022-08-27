package kopo.poly.service;

import kopo.poly.dto.api.LodgingDto;
import kopo.poly.enums.LanguageType;

import java.util.List;

public interface ITourismApiService {


    boolean supports(LanguageType languageType);


    List<LodgingDto> getLodgingList(LanguageType languageType, String pageNo, String areaCode, String sigunguCode) throws Exception;


}
