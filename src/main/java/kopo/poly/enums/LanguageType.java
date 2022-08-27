package kopo.poly.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LanguageType {
    KOR("KorService"), // 국문 서비스
    ENG("EngService"), // 영문 서비스
    JPN("JpnService"), // 일문 서비스
    SPN("SpnService"), // 서어 서비스
    RUS("RusService"), // 노어 서비스
    GER("GerService"), // 독어 서비스
    ;


    private final String languageType;
    }
