package kopo.poly.service;

import kopo.poly.enums.LanguageType;
import kopo.poly.vo.ApiAreaBasedDto;
import kopo.poly.vo.ApiKeywordDto;
import kopo.poly.vo.ApiLodgingDto;
import kopo.poly.vo.request.TourismRequest;

import java.util.List;

public interface ITourismService {


    // 지역 별 숙박 정보 조회
    List<ApiLodgingDto> getLodgingList(TourismRequest request) throws Exception;


    // 지역기반 관광 정보 조회
    List<ApiAreaBasedDto> getTourismInfoByArea(TourismRequest request) throws Exception;


    // 키워드를 기반으로 관광 정보 조회
    List<ApiKeywordDto> getTourismInfoByKeyword(TourismRequest request) throws Exception;
}