package kr.co.greendae.entity.Lecture;

import jakarta.persistence.*;
import kr.co.greendae.entity.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Subject (과목)
 * 개설되기 전의 과목 정보
 * 예) 자바 프로그래밍
 */
@Data@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String code;  // 과목 코드
    String title; // 과목 이름
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
