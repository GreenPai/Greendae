package kr.co.greendae.dto.department;

import kr.co.greendae.dto.college.CollegeDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DepartmentDTO {

    private int deptNo;            // 학과번호

    private String collegeName;         // 단과대학

    private String deptName;       // 학과명
    private String deptEname;   // 영문명

    private String establishedYear; // 설립연도
    private String deptChair;      // 학과장
    private String deptHp;         // 학과 연락처
    private String deptOffice;     // 학과 사무실

    private int totalStudents;      // 소속 학생 수
    private int totalLecturers;     // 소속 강의 수
    private int totalProfessors;    // 소속 교수 수

    private CollegeDTO college;

    public boolean isValid() {
        if (deptName == null || deptName.isBlank()) return false;
        if (deptEname == null || deptEname.isBlank()) return false;
        if (establishedYear == null || establishedYear.isBlank()) return false;
        if (deptHp == null || deptHp.isBlank()) return false;
        if (deptOffice == null || deptOffice.isBlank()) return false;

        return true;
    }


}
