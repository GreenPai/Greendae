package kr.co.greendae.entity.Lecture;

import jakarta.persistence.*;
import kr.co.greendae.entity.basic.BaseEntity;
import kr.co.greendae.entity.user.Student;
import lombok.*;

import java.math.BigDecimal;

/**
 * 수강신청 엔티티 :
 * lecture
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Register extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regStdNo", referencedColumnName = "stdNo", nullable = false)
    private Student student;

    /*
    *   Lecture (외례키 : LecNo)
    *   -------------------------------------------------
    *   lecCate  : 과목구분
    *   professor - user - name : 교수 이름
    *   lecRoom  : 강의실
    *   lecName  : 과목명
    *   lecGrade : 학년
    * */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regLecNo", referencedColumnName = "lecNo", nullable = false)
    private Lecture lecture;

    private Integer regYear;
    private Integer regSemester;

    @Enumerated(EnumType.STRING)
    private Grade regGradeScore; // 성적

    @Enumerated(EnumType.STRING)
    private RegisterStatus status; // 수강 신청 - 신청, 취소

    private BigDecimal regAttenScore;   // 출석 점수
    private BigDecimal regMidScore;     // 중간고사 점수
    private BigDecimal regFinalScore;   // 기말고사 점수
    private BigDecimal regEtcScore;     // 기타 점수
    private BigDecimal regTotalScore;   // 총점

    
}
