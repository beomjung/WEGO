package kopo.poly.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LanguageType {
    KOR("KorService"), // KOR 서비스
    ENG("EngService"), // ENG 서비스
    ;


    private final String languageType;
}
