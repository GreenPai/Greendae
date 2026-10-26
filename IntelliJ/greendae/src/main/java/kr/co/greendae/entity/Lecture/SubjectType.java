package kr.co.greendae.entity.Lecture;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * SubjectType: 이수 구분 -> Subject에서 사용
 * */

@Getter
@RequiredArgsConstructor
public enum SubjectType {

    MAJOR_REQUIRED("전공필수"),
    MAJOR_ELECTIVE("전공선택"),
    GENERAL("교양");

    private final String description;
}