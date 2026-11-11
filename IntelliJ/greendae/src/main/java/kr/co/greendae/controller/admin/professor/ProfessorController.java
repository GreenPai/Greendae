package kr.co.greendae.controller.admin.professor;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greendae.dto.college.CollegeDTO;
import kr.co.greendae.dto.department.DepartmentDTO;
import kr.co.greendae.dto.user.ProfessorDTO;
import kr.co.greendae.dto.user.UserDTO;
import kr.co.greendae.entity.user.Role;
import kr.co.greendae.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/professor")
public class ProfessorController {

    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    // 교수 등록 페이지
    @GetMapping("/register")
    public String professor(Model model){

        // Select 박스를 위한 대학 정보
        List<CollegeDTO> collegeDTOS = adminService.findAllCollege();
        List<DepartmentDTO> departmentDTOS = adminService.findAllDepartmentByName(collegeDTOS.get(0).getName());

        //대학 정보
        model.addAttribute("collegeDTOS",collegeDTOS);
        model.addAttribute("departmentDTOS",departmentDTOS);
        return "/admin/register/professor";
    }

    // 교수 등록
    @PostMapping("/register")
    public String  professor(ProfessorDTO professorDTO, UserDTO userDTO
            , @RequestParam("graduationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate graduationDate,
                             @RequestParam("appointmentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate
            , HttpServletRequest req){

        // 교수번호 : 연도 + 학과번호 + 순번 자동 조합
        String prodNo = String.valueOf(appointmentDate.getYear());


        DepartmentDTO departmentDTO = adminService.findDepartmentByName(professorDTO.getDepartmentD());
        prodNo += departmentDTO.getDeptNo();

        // 비밀번호 추출 (주민번호 뒷자리)
        String[] passStr = userDTO.getSsn().split("-");
        String pass = passwordEncoder.encode(passStr[1]); ;
        userDTO.setPass(pass);
        userDTO.setRole(Role.ADMIN);
        userDTO.setRegip(req.getRemoteAddr());

        // User 테이블에 저장 - code는 교수번호
        String code = adminService.registerUser(userDTO, prodNo);

        professorDTO.setUid(code);
        professorDTO.setProNo(code);
        professorDTO.setDeptNo(departmentDTO.getDeptNo());

        adminService.registerProfessor(professorDTO, userDTO, departmentDTO);

        // 학과에 교수 수 + 1 하기
        adminService.CountUpProfessor(departmentDTO);
        return "redirect:/admin/professor/register";
    }



}
