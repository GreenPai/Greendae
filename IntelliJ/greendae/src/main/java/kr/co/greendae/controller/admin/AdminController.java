package kr.co.greendae.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greendae.dto.college.CollegeDTO;
import kr.co.greendae.dto.department.*;
import kr.co.greendae.dto.page.PageRequestDTO;
import kr.co.greendae.dto.support.LectureDTO;
import kr.co.greendae.dto.user.PageProfessorResponseDTO;
import kr.co.greendae.dto.user.PageStudentResponseDTO;
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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// 관리자
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    // 메인 페이지
    @GetMapping("/main")
    public String main(){
        return "/admin/main";
    }

    // 학과를 선택하면 관련 교수를 출력
    @ResponseBody
    @GetMapping("/professor/list")
    public List<ProfessorDTO> professorList(@RequestParam("department") String department){
        List<ProfessorDTO> professorDTOS = adminService.findAllProfessorByName(department);
        return professorDTOS;
    }

    /*
     * 목록
     * */

    // 학과 검색
    @GetMapping("/departments/search")
    public String search(PageDepartmentRequestDTO pageRequestDTO, Model model){

        // 서비스 호출
        PageDepartmentResponseDTO pageResponseDTO = adminService.searchAllDepartment(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/list/departmentSearch";
    }

    // 교수 리스트 출력
    @GetMapping("/professors/list")
    public String professorList(Model model, PageRequestDTO pageRequestDTO){

        PageProfessorResponseDTO pageProfessorResponseDTO = adminService.findAllProfessor(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageProfessorResponseDTO);

        return "/admin/list/professor";
    }

    // 교육 운영 현황 리스트
    @GetMapping("/operation/list")
    public String  operation(Model model, PageRequestDTO pageRequestDTO){

        PageLectureResponseDTO pageResponseDTO = adminService.allLecture(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/list/operation";
    }

    // 교육 운영 검색
    @GetMapping("/operation/search")
    public String operationSearch(PageRequestDTO pageRequestDTO, Model model){

        // 서비스 호출
        PageLectureResponseDTO pageResponseDTO = adminService.searchAllLecture(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/list/operationSearch";
    }


    // 수강 현황 리스트
    @GetMapping("/lecture/list")
    public String  lectureList(Model model, PageRequestDTO pageRequestDTO){

        PageLectureResponseDTO pageResponseDTO = adminService.allLecture(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/list/lecture";
    }

    // 수강 현황 검색
    // 교육 운영 현황 리스트
    @GetMapping("/lecture/search")
    public String lectureSearch(PageRequestDTO pageRequestDTO, Model model){

        // 서비스 호출
        PageLectureResponseDTO pageResponseDTO = adminService.searchAllLecture(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/list/lectureSearch";
    }

    // 수강 현황 리스트
    @GetMapping("/register/list")
    public String  register(Model model, PageRequestDTO pageRequestDTO){

        PageRegisterResponseDTO pageResponseDTO = adminService.allRegister(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/list/register";
    }

    @GetMapping("/register/search")
    public String registerSearch(PageRequestDTO pageRequestDTO, Model model){

        // 서비스 호출
        PageRegisterResponseDTO pageResponseDTO = adminService.searchAllRegister(pageRequestDTO);
        model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/list/registerSearch";
    }



}