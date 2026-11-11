package kr.co.greendae.controller.admin.lecture;

import kr.co.greendae.dto.college.CollegeDTO;
import kr.co.greendae.dto.department.DepartmentDTO;
import kr.co.greendae.dto.support.LectureDTO;
import kr.co.greendae.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/lecture")
public class LectureController {

    private final AdminService adminService;

    // 강의 등록
    @GetMapping("/register")
    public String lecture(Model model){

        // Select 박스를 위한 대학 정보
        List<CollegeDTO> collegeDTOS = adminService.findAllCollege();
        List<DepartmentDTO> departmentDTOS = adminService.findAllDepartmentByName(collegeDTOS.get(0).getName());

        //대학 정보
        model.addAttribute("collegeDTOS",collegeDTOS);
        model.addAttribute("departmentDTOS",departmentDTOS);

        return "/admin/register/lecture";
    }


    @PostMapping("/register")
    public String lecture(LectureDTO lectureDTO){

        // 과목 코드 만들기

        String[] year = lectureDTO.getLecScheduleStart().split("-");
        String lecNo = year[0];

        DepartmentDTO departmentDTO = adminService.findDepartmentByName(lectureDTO.getLecClass());

        lecNo += departmentDTO.getDeptNo();

        lectureDTO.setLecClass(departmentDTO.getDeptName());

        adminService.registerLecture(lectureDTO, lecNo);

        adminService.CountUpLecture(departmentDTO);

        return "redirect:/admin/lecture/register";
    }







}
