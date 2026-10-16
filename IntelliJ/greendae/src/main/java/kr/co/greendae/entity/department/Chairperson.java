package kr.co.greendae.entity.department;

import jakarta.persistence.*;
import kr.co.greendae.entity.college.College;
import kr.co.greendae.entity.user.Professor;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Chairperson")
public class Chairperson {
    // 학과장 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proNo")
    private Professor professor;

}
