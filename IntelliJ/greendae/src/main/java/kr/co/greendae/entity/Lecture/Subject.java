package kr.co.greendae.entity.Lecture;

import jakarta.persistence.*;
import kr.co.greendae.entity.user.Role;
import lombok.*;

/**
 * Subject (과목)
 * 개설되기 전의 과목 정보
 * 예) 자바 프로그래밍
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int no;

    @Column(nullable = false, unique = true)
    String code;  // 과목 코드

    @Column(nullable = false)
    String title; // 과목 이름

    @Column(nullable = false)
    int credits;  // 이수 학점

    /**
     * 이수 구분 :
     * MAJOR_REQUIRED("전공필수"),
     * MAJOR_ELECTIVE("전공선택"),
     * GENERAL("교양");
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private SubjectType type;

    
}
