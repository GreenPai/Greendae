package kr.co.greendae.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greendae.dto.college.CollegeDTO;
import kr.co.greendae.dto.department.DepartmentDTO;
import kr.co.greendae.dto.page.PageRequestDTO;
import kr.co.greendae.dto.support.StudentDTO;
import kr.co.greendae.dto.user.PageStudentResponseDTO;
import kr.co.greendae.dto.user.UserDTO;
import kr.co.greendae.entity.user.Role;
import kr.co.greendae.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/student")
public class StudentController {

    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    // 학생 리스트 페이지
    @GetMapping("/list")
    public String  studentList(Model model, PageRequestDTO pageRequestDTO){

        PageStudentResponseDTO pageStudentResponseDTO = adminService.findAllStudent(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageStudentResponseDTO);
        return "/admin/list/student";
    }

    // 학생 등록 페이지
    @GetMapping("/register")
    public String student(Model model){


        // Select 박스를 위한 대학 정보
        List<CollegeDTO> collegeDTOS = adminService.findAllCollege();
        List<DepartmentDTO> departmentDTOS = adminService.findAllDepartmentByName(collegeDTOS.get(0).getName());

        //대학 정보
        model.addAttribute("collegeDTOS",collegeDTOS);
        model.addAttribute("departmentDTOS",departmentDTOS);
        return "/admin/register/student";
    }

    // 학생 등록
    @PostMapping("/register")
    public String  student(StudentDTO studentDTO, UserDTO userDTO
            , HttpServletRequest req){

        // 학생번호 : 연도 + 학과번호 + 순번 자동 조합
        String studNo = studentDTO.getAdmission_year();  // 연도 추가
        DepartmentDTO departmentDTO = adminService.findDepartmentByName(studentDTO.getStdClass());
        studNo += departmentDTO.getDeptNo();

        log.info("Department: " + departmentDTO);

        // 비밀번호 추출 (주민번호 뒷자리)
        String[] passStr = userDTO.getSsn().split("-");
        String pass = passwordEncoder.encode(passStr[1]); ;
        userDTO.setPass(pass);
        userDTO.setRole(Role.STUDENT);
        userDTO.setRegip(req.getRemoteAddr());

        // User 테이블에 저장 - code는 학생번호
        String code = adminService.registerUser(userDTO, studNo);

        studentDTO.setUid(code);
        studentDTO.setStdNo(code);
        adminService.registerStudent(studentDTO, userDTO, departmentDTO);

        adminService.CountUpStudent(departmentDTO);

        return "redirect:/admin/student/register";
    }
}
