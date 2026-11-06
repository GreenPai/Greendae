package kr.co.greendae.controller.admin;

import kr.co.greendae.dto.college.CollegeDTO;
import kr.co.greendae.dto.department.DepartmentDTO;
import kr.co.greendae.dto.page.PageRequestDTO;
import kr.co.greendae.dto.user.PageStudentResponseDTO;
import kr.co.greendae.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/student")
public class StudentController {

    private final AdminService adminService;

    // 학생 리스트 출력
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
}
