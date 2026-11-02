package kr.co.greendae.entity.Lecture;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegisterStatus {

    REGISTERED("신청완료"),
    CANCELED("수강취소");

    private final String description;
}
