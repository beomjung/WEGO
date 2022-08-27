package kopo.poly.factory;

import kopo.poly.enums.LanguageType;
import kopo.poly.service.ITourismApiService;
import kopo.poly.service.impl.KorTourismApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Service Factory : 언어에 맞는 서비스를 찾아서 반환 --> { Eng = EngTourismApiService, Kor --> KorTourismApiService }
 */
@Component
@RequiredArgsConstructor
public class ApiServiceFactory {
    private final List<ITourismApiService> tourismApiServiceList;
    private final KorTourismApiService korTourismApiService;
    private final Map<LanguageType, ITourismApiService> tourismApiServiceFactoryCache;


    /**
     * 아직 API 정보를 다 확인 X
     * + Kor 서비스 and Other (Eng, Jpn) 서비스 분류 코드가 다름
     * @param languageType
     * @return
     */
    public ITourismApiService findTourismApiService(final LanguageType languageType) {

        // TourismApiService 를 Map 에서 우선적으로 찾음
        ITourismApiService tourismApiService = tourismApiServiceFactoryCache.get(languageType);


        // 만약 Map 에 해당 서비스가 없다면 List 를 탐색
        if (tourismApiService != null) {
            return tourismApiService;
        }

        tourismApiService = tourismApiServiceList.stream()
                .filter(service -> service.supports(languageType))
                .findFirst().orElseThrow(NoSuchElementException::new); // List 에도 해당하는 서비스가 없다면 Exception

        return tourismApiService;
    }
}
