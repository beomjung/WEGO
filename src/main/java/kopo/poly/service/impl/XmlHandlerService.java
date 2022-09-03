package kopo.poly.service.impl;

import kopo.poly.enums.ApiServiceType;
import kopo.poly.vo.ApiAreaBasedDto;
import kopo.poly.vo.ApiKeywordDto;
import kopo.poly.vo.ApiLodgingDto;
import kopo.poly.vo.introductions.*;
import kopo.poly.enums.LanguageType;
import kopo.poly.vo.request.TourismRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.yaml.snakeyaml.util.UriEncoder;

import javax.xml.parsers.DocumentBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * XML 파일 처리 관련 Service 및 URL Param 설정
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class XmlHandlerService {

    private final DocumentBuilder documentBuilder;
    private final Environment env;

    /**
     * 서비스 파라미터를 받아 Return URL
     * @param param Parameter 정보 (각 서비스에 맞는 파라미터) 필수 --> LanguageType && ServiceType
     * + 한글 Param 이 예상될 경우 인코딩 필수 UriEncoder.encode({value})
     * + 값이 없을 있을 경우 Param 추가 or ""
     * @return Service URI
     * @throws Exception 필수 Param 이 없거나, 포함할 수 없는 Param 이 포함될 경우 API 호출 시 Exception (500) 발생
     */

    // ServiceKey & Default Value  Setting
    public URI getUri(TourismRequest param) throws Exception {
        final URI uri  = new URI("https://api.visitkorea.or.kr/openapi/service/rest/"
                // 필수 Param
                + param.getLanguageType().getLanguageType() + "/" // 요청할 언어 Type 설정
                + param.getServiceType().getServiceEndPoint() + "?" // 서비스 EndPoint 설정
                + "MobileOS=ETC" // 필수
                + "&MobileApp=AppTest" // 필수
                + "&serviceKey=" + env.getProperty("tourism.key") // 필수

                // 요청값이 있으면 Param 설정 or Pass
                + (param.getAreaCode() != null ? "&areaCode=" + param.getAreaCode() : "") // 지역 코드
                + (param.getSigunguCode() != null ? "&sigunguCode=" + param.getSigunguCode() : "") // 시군구 코드
                + (param.getPageNo() != null ? "&pageNo=" + param.getPageNo() : "") // Page 번호
                + (param.getArrange() != null ? "&arrange=" + param.getArrange() : "") // 정렬 기준
                + (param.getContentId() != null ? "&contentId=" + param.getContentId() : "") // 관광 정보 고유 번호
                // 키워드를 사용하여 정보 조회 시 사용 (국문 서비스일 경우 인코딩 필수)
                + (param.getKeyword() != null ? "&keyword=" + UriEncoder.encode(param.getKeyword()) : "")

                // 관광 정보 상세 조회 시 사용 (ContentType 이 Param 으로 넘어올 경우 둘 중 하나만 설정 됨)
                + (param.getContentType() != null && param.getLanguageType() == LanguageType.KOR ?
                "&contentTypeId=" + param.getContentType().getKorContentTypeId() : "") // Service 언어가 KOR 일 경우

                + (param.getContentType() != null && param.getLanguageType() != LanguageType.KOR ? // Service 언어가 KOR 이 아닐 경우
                "&contentTypeId=" + param.getContentType().getMultilingualContentTypeId() : "")

                // 분류 기준 cat1 없이 cat2 사용 불가능
                + (param.getCat1() != null ? "&cat1=" + param.getCat1() : "") // 대분류
                + (param.getCat1() != null && param.getCat2() != null ? "&cat2=" + param.getCat2() : "") // 중분류
                + (param.getCat2() != null && param.getCat3() != null ? "&cat3=" + param.getCat3() : "") // 소분류
        );

        log.info("URI : " + uri);

        return uri;
    }


    // XML 파일에서 item, Main Response 추출
    public NodeList getNoteListFromURI(final URI uri) throws Exception {
        Document doc = documentBuilder.parse(String.valueOf(uri));
        NodeList items = doc.getElementsByTagName("item");

        return items;
    }


    // ########################################## ElementToDto  ##########################################

    /**
     * Element item (Node) 를 전송 시 Dto Type 으로 변환하여 return
     *
     * @param element
     * @return
     * @throws Exception
     */

    // About 교통 정보 (다국어 서비스에서만 사용)
    public TransportationResult getTransportationResultFromElement(final Element element) throws Exception {
        return TransportationResult.builder()
                .contenttypeid(getTagValue("contenttypeid", element))
                .contentid(getTagValue("contentid", element))
                .chkcreditcardtraffic(getTagValue("chkcreditcardtraffic", element))
                .conven(getTagValue("conven", element))
                .disablefacility(getTagValue("disablefacility", element))
                .foreignerinfocenter(getTagValue("foreignerinfocenter", element))
                .infocentertraffic(getTagValue("infocentertraffic", element))
                .mainroute(getTagValue("mainroute", element))
                .operationtimetraffic(getTagValue("operationtimetraffic", element))
                .parkingtraffic(getTagValue("parkingtraffic", element))
                .restroomtraffic(getTagValue("restroomtraffic", element))
                .shipinfo(getTagValue("shipinfo", element)).build();

    }

    // About 레포츠 정보
    public LeportsResult getLeportsResultFromElement(final Element element) throws Exception {
        return LeportsResult.builder()
                .contentid(getTagValue("contentid", element)) // 기본 응답
                .contenttypeid(getTagValue("contenttypeid", element)) // 기본 응답
                .accomcountleports(getTagValue("accomcountleports", element)) // 수용 인원
                .expagerangeleports(getTagValue("expagerangeleports", element)) // 체험 가능연령
                .infocenterleports(getTagValue("infocenterleports", element)) // 문의 및 안내
                .openperiod(getTagValue("openperiod", element)) // 개장시간
                .parkingfeeleports(getTagValue("parkingfeeleports", element)) // 주차요금
                .parkingleports(getTagValue("parkingleports", element)) // 주차시설
                .reservation(getTagValue("reservation", element)) // 예약안내
                .restdateleports(getTagValue("restdateleports", element)) // 쉬는 날
                .scaleleports(getTagValue("scaleleports", element)) // 규모
                .usefeeleports(getTagValue("usefeeleports", element)) // 입장료
                .usetimeleports(getTagValue("usetimeleports", element)) // 이용시간

                // 국문만 제공
                .chkbabycarriage(getTagValue("chkbabycarriage", element)) // 유모차대여 정보
                .chkcreditcardculture(getTagValue("chkcreditcardculture", element)) // 신용카드가능 정보
                .chkpetculture(getTagValue("chkpetculture", element)).build(); // 동물 가능 여부

    }

    // About 축제 정보
    public FestivalInfoResult getFestivalInfoResultFromElement(final Element element) throws Exception {
        return FestivalInfoResult.builder()
                .contentid(getTagValue("contentid", element)) // 기본 응답
                .contenttypeid(getTagValue("contenttypeid", element)) // 기본 응답
                .agelimit(getTagValue("agelimit", element)) // 관람 가능 연령
                .bookingplace(getTagValue("bookingplace", element)) // 예매체
                .discountinfofestival(getTagValue("discountinfofestival", element)) // 할인 정보
                .eventenddate(getTagValue("eventenddate", element)) // 행사 종료일
                .eventhomepage(getTagValue("eventhomepage", element)) // 행사 홈페이지
                .eventplace(getTagValue("eventplace", element)) // 행사 장소
                .eventstartdate(getTagValue("eventstartdate", element)) // 행사 시작일
                .placeinfo(getTagValue("placeinfo", element)) // 행사장 위치안내
                .playtime(getTagValue("playtime", element)) // 공연시간
                .program(getTagValue("program", element)) // 행사 프로그램
                .spendtimefestival(getTagValue("spendtimefestival", element)) // 관람 소요시간
                .sponsor1(getTagValue("sponsor1", element)) // 주최자 정보
                .sponsor1tel(getTagValue("sponsor1tel", element)) // 주최자 연락처
                .sponsor2(getTagValue("sponsor2", element)) // 주관사 정보
                .sponsor2tel(getTagValue("sponsor2tel", element)) // 주관사 연력처
                .subevent(getTagValue("subevent", element)) // 부대 행사
                .usetimefestival(getTagValue("usetimefestival", element)) // 이용 요금
                // 국문만 제공
                .festivalgrade(getTagValue("festivalgrade", element)).build(); // 축제 등급
    }

    //About 숙박 시설
    public LodgingResult getLodgingResultFromElement(final Element element) throws Exception {
        return LodgingResult.builder()
                .contentid(getTagValue("contentid", element)) // 기본 응답
                .contenttypeid(getTagValue("contenttypeid", element)) // 기본 응답
                .accomcountlodging(getTagValue("accomcountlodging", element)) // 수용 가능인원
                .benikia(getTagValue("benikia", element)) // 베니키아 여부
                .checkintime(getTagValue("checkintime", element)) // 입실 시간
                .checkouttime(getTagValue("checkouttime", element)) // 퇴실 시간
                .chkcooking(getTagValue("chkcooking", element)) // 취사 여부
                .foodplace(getTagValue("foodplace", element)) // 식음료장
                .goodstay(getTagValue("goodstay", element)) // 굿스테이 여부
                .hanok(getTagValue("hanok", element)) // 한옥 여부
                .infocenterlodging(getTagValue("infocenterlodging", element)) // 문의 및 안내
                .parkinglodging(getTagValue("parkinglodging", element)) // 주차 시설
                .pickup(getTagValue("pickup", element)) // 픽업 서비스
                .roomcount(getTagValue("roomcount", element)) // 객실 수
                .reservationlodging(getTagValue("reservationlodging", element)) // 예약 안내
                .reservationurl(getTagValue("reservationurl", element)) // 예약안내 홈페이지
                .roomtype(getTagValue("roomtype", element)) // 객실 유형
                .scalelodging(getTagValue("scalelodging", element)) // 규모
                .subfacility(getTagValue("subfacility", element)) // 부대 시설
                // 국문만 제공
                .barbecue(getTagValue("barbecue", element)) // 바비큐장 여부
                .beauty(getTagValue("beauty", element)) // 뷰티시설 정보
                .beverage(getTagValue("beverage", element)) // 식음료장 여부
                .bicycle(getTagValue("bicycle", element)) // 자전거 대여 여부
                .campfire(getTagValue("campfire", element)) // 캠프파이어 여부
                .fitness(getTagValue("fitness", element)) // 휘트니스 센터 여부
                .karaoke(getTagValue("karaoke", element)) // 노래방 여부
                .publicbath(getTagValue("publicbath", element)) // 공용 샤워실 여부
                .publicpc(getTagValue("publicpc", element)) // 공요 PC실 여부
                .sauna(getTagValue("sauna", element)).build(); // 사우나실 여부

    }

    // About 음식점
    public RestaurantsResult getRestaurantsResultFromElement(final Element element) throws Exception {
        return RestaurantsResult.builder()
                .contentid(getTagValue("contentid", element)) // 기본 응답
                .contenttypeid(getTagValue("contenttypeid", element)) // 기본 응답
                .firstmenu(getTagValue("firstmenu", element)) // 대표 메뉴
                .infocenterfood(getTagValue("infocenterfood", element)) // 문의 및 안내
                .opendatefood(getTagValue("opendatefood", element)) // 개업일
                .opentimefood(getTagValue("opentimefood", element)) // 영업시간
                .parkingfood(getTagValue("parkingfood", element)) // 주차시설
                .reservationfood(getTagValue("reservationfood", element)) // 예약 안내
                .restdatefood(getTagValue("restdatefood", element)) // 쉬는날
                .scalefood(getTagValue("scalefood", element)) // 규모
                .seat(getTagValue("seat", element)) // 좌석 수
                .smoking(getTagValue("smoking", element)) // 금연/흡연 여부
                .treatmenu(getTagValue("treatmenu", element)) // 취급 메뉴
                .lcnsno(getTagValue("lcnsno", element)) // 인허가 번호

                // 국문만 제공
                .chkcreditcardfood(getTagValue("chkcreditcardfood", element)) // 신용카드 가능 여부
                .discountinfofood(getTagValue("discountinfofood", element)) // 할인 정보
                .kidsfacility(getTagValue("kidsfacility", element)) // 어린이 놀이방
                .packing(getTagValue("packing", element)).build(); // 포장 가능 여부

    }

    // About 문화 시설
    public CulturalFacilitiesResult getCulturalFacilitiesResultFromElement(final Element element) throws Exception {
        return CulturalFacilitiesResult.builder()
                .contentid(getTagValue("contentid", element)) // 기본 응답
                .contenttypeid(getTagValue("contenttypeid", element)) // 기본 응답
                .accomcountculture(getTagValue("accomcountculture", element)) // 수용인원
                .infocenterculture(getTagValue("infocenterculture", element)) // 문의 및 안내
                .parkingculture(getTagValue("parkingculture", element)) // 주차 시설
                .parkingfee(getTagValue("parkingfee", element)) // 주차 요금
                .restdateculture(getTagValue("restdateculture", element)) // 쉬는날
                .usefee(getTagValue("usefee", element)) // 이용요금
                .usetimeculture(getTagValue("usetimeculture", element)) // 이용 시간
                .scale(getTagValue("scale", element)) // 규모
                .spendtime(getTagValue("spendtime", element)) // 관람 소요 시간

                // 국문만 제공
                .chkbabycarriage(getTagValue("chkbabycarriage", element)) // 유모차대여 정보
                .chkcreditcardculture(getTagValue("chkcreditcardculture", element)) // 신용카드가능 정보
                .chkpetculture(getTagValue("chkpetculture", element)) // 동물 가능 여부
                .discountinfo(getTagValue("discountinfo", element)).build(); // 할인 정보
    }

    // About 여행 코스 정보 (국문 서비스에서만 사용)
    public TravelCourseResult getTravelCourseResultFromElement(final Element element) throws Exception {
        return TravelCourseResult.builder()
                .contentid(getTagValue("contentid", element))
                .contenttypeid(getTagValue("contentid", element))
                .distance(getTagValue("distance", element)) // 코스 총거리
                .infocentertourcourse(getTagValue("infocentertourcourse", element)) // 문의 및 안내
                .schedule(getTagValue("schedule", element)) // 코스 일정
                .taketime(getTagValue("taketime", element)) // 코스 총 소요시간
                .theme(getTagValue("theme", element)).build(); // 코스 테마
    }

    // About 쇼핑 정보
    public ShoppingResult getShoppingResultFromElement(final Element element) throws Exception {
        return ShoppingResult.builder()
                .contentid(getTagValue("contentid", element)) // 기본 응답
                .contenttypeid(getTagValue("contenttypeid", element)) // 기본 응답
                .fairday(getTagValue("fairday", element)) // 장서는 날
                .infocentershopping(getTagValue("infocentershopping", element)) // 문의 및 안내
                .opendateshopping(getTagValue("opendateshopping", element)) // 개장일
                .opentime(getTagValue("opentime", element)) // 영업시간
                .parkingshopping(getTagValue("parkingshopping", element)) // 주차시설
                .restdateshopping(getTagValue("restdateshopping", element)) // 쉬는 날
                .restroom(getTagValue("restroom", element)) // 화장실 설명
                .saleitem(getTagValue("saleitem", element)) // 판매 품목
                .scaleshopping(getTagValue("scaleshopping", element)) // 규모
                .shopguide(getTagValue("shopguide", element)) // 매장안내
                // 국문만 제공
                .saleitemcost(getTagValue("saleitemcost", element)) // 판매 품목별 가격
                .chkbabycarriage(getTagValue("chkbabycarriage", element)) // 유모차대여 정보
                .chkcreditcardculture(getTagValue("chkcreditcardculture", element)) // 신용카드가능 정보
                .chkpetculture(getTagValue("chkpetculture", element)) // 동물 가능 여부
                .culturecenter(getTagValue("culturecenter", element)).build(); // 문화센터 바로가기

    }

    public TouristDestinationResult getTouristDestinationResultFromElement(final Element element) throws Exception {
        return TouristDestinationResult.builder()
                .contentid(getTagValue("contentid", element)) // 기본 응답
                .contenttypeid(getTagValue("contenttypeid", element)) // 기본 응답
                .accomcount(getTagValue("accomcount", element))// 수용인원
                .expagerange(getTagValue("expagerange", element)) // 체험가능 연령
                .expguide(getTagValue("expguide", element)) // 체험 안내
                .heritage1(getTagValue("heritage1", element)) // 세계 문화유산 유무
                .infocenter(getTagValue("infocenter", element)) // 문의 및 안내
                .opendate(getTagValue("opendate", element)) // 개장일
                .parking(getTagValue("parking", element)) // 주차시설
                .restdate(getTagValue("restdate", element)) // 쉬는날
                .useseason(getTagValue("useseason", element)) // 이용시기
                .usetime(getTagValue("usetime", element)) // 이용 시간

                // 국문만 제공
                .heritage2(getTagValue("heritage2", element)) // 세계 자연유산 유무
                .heritage3(getTagValue("heritage3", element)) // 세계 기록유산 유무
                .chkpet(getTagValue("chkpet", element)) // 동물 가능 여부
                .chkcreditcard(getTagValue("chkcreditcard", element)) // 신용카드 가능 여부
                .chkbabycarriage(getTagValue("chkbabycarriage", element)).build(); // 유모차 대여 여부

    }

    // ApiLodgingDto 숙박 정보 조회 실행 시 사용됨
    public ApiLodgingDto getLodgingDtoFromElement(final Element element) throws Exception {
        return ApiLodgingDto.builder()
                .addr1(getTagValue("addr1", element))
                .addr2(getTagValue("addr2", element))
                .areacode(getTagValue("areacode", element))
                .benikia(getTagValue("benikia", element))
                .cat1(getTagValue("cat1", element))
                .cat2(getTagValue("cat1", element))
                .cat3(getTagValue("cat1", element))
                .areacode(getTagValue("areacode", element))
                .contentid(getTagValue("contentid", element))
                .contenttypeid(getTagValue("contenttypeid", element))
                .createdtime(getTagValue("createdtime", element))
                .firstimage(getTagValue("firstimage", element))
                .firstimage2(getTagValue("firstimage2", element))
                .goodstay(getTagValue("goodstay", element))
                .hanok(getTagValue("hanok", element))
                .mapx(getTagValue("mapx", element))
                .mapy(getTagValue("mapy", element))
                .mlevel(getTagValue("mlevel", element))
                .modifiedtime(getTagValue("modifiedtime", element))
                .readcount(getTagValue("readcount", element))
                .tel(getTagValue("tel", element))
                .title(getTagValue("title", element))
                .booktour(getTagValue("booktour", element))
                .sigungucode(getTagValue("sigungucode", element)).build();
    }

    // AreaBasedDto 지역기반 정보 조회 실행 시 사용
    public ApiAreaBasedDto getAreaBasedDtoFromElement(Element element) throws Exception {
        return ApiAreaBasedDto.builder()
                .addr1(getTagValue("addr1", element))
                .addr2(getTagValue("addr2", element))
                .areacode(getTagValue("areacode", element))
                .cat1(getTagValue("cat1", element))
                .cat2(getTagValue("cat1", element))
                .cat3(getTagValue("cat1", element))
                .areacode(getTagValue("areacode", element))
                .contentid(getTagValue("contentid", element))
                .contenttypeid(getTagValue("contenttypeid", element))
                .createdtime(getTagValue("createdtime", element))
                .firstimage(getTagValue("firstimage", element))
                .firstimage2(getTagValue("firstimage2", element))
                .mapx(getTagValue("mapx", element))
                .mapy(getTagValue("mapy", element))
                .mlevel(getTagValue("mlevel", element))
                .modifiedtime(getTagValue("modifiedtime", element))
                .readcount(getTagValue("readcount", element))
                .tel(getTagValue("tel", element))
                .title(getTagValue("title", element))
                .sigungucode(getTagValue("sigungucode", element)).build();

    }


    // ApiKeywordDto 를 Element 에서 변환
    public ApiKeywordDto getKeywordDtoFromElement(Element element) throws Exception {
        return ApiKeywordDto.builder()
                .booktour(getTagValue("booktour", element))
                .addr1(getTagValue("addr1", element))
                .addr2(getTagValue("addr2", element))
                .areacode(getTagValue("areacode", element))
                .cat1(getTagValue("cat1", element))
                .cat2(getTagValue("cat1", element))
                .cat3(getTagValue("cat1", element))
                .areacode(getTagValue("areacode", element))
                .contentid(getTagValue("contentid", element))
                .contenttypeid(getTagValue("contenttypeid", element))
                .createdtime(getTagValue("createdtime", element))
                .firstimage(getTagValue("firstimage", element))
                .firstimage2(getTagValue("firstimage2", element))
                .mapx(getTagValue("mapx", element))
                .mapy(getTagValue("mapy", element))
                .mlevel(getTagValue("mlevel", element))
                .modifiedtime(getTagValue("modifiedtime", element))
                .readcount(getTagValue("readcount", element))
                .tel(getTagValue("tel", element))
                .title(getTagValue("title", element))
                .sigungucode(getTagValue("sigungucode", element)).build();

    }


    // Element 에서 Tag 값으로 Value 를 찾음
    public String getTagValue(String tag, Element eElement) throws Exception {
        try {
            Optional<NodeList> nlList = Optional.of(eElement.getElementsByTagName(tag).item(0).getChildNodes());
            Node nValue = nlList.get().item(0);
            if (nValue == null)
                return "";
            return nValue.getNodeValue();

        } catch (Exception exception) {
            log.debug("exception : " + exception);
            return ""; // 해당 Tag 가 없는 경우 catch & return ""
        }
    }
}
