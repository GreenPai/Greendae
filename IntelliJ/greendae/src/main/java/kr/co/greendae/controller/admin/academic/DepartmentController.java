package kr.co.greendae.controller.admin.academic;

import kr.co.greendae.dto.department.DepartmentDTO;
import kr.co.greendae.dto.department.PageDepartmentRequestDTO;
import kr.co.greendae.dto.department.PageDepartmentResponseDTO;
import kr.co.greendae.service.admin.acacemic.AdDepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/department")
public class DepartmentController {

    private final AdDepartmentService departmentService;

    @GetMapping("/list")
    public String departmentList(Model model, PageDepartmentRequestDTO pageDepartmentRequestDTO){

        // 전체 학과 조회 서비스 호출(JPA)
        PageDepartmentResponseDTO pageDepartmentResponseDTO = departmentService.findAllDepartment(pageDepartmentRequestDTO);

        System.out.println("--------");
        System.out.println("pageDepartmentResponseDTO = " + pageDepartmentResponseDTO);

        model.addAttribute("pageResponseDTO",pageDepartmentResponseDTO);
        return "/admin/list/department";
    }

    @PostMapping("/register")
    public String department(DepartmentDTO departmentDTO,
                             @RequestParam("date")
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){

        log.info("학과 정보 등록 컨트롤러 실행합니다.");

        departmentDTO.setEstablishedYear(String.valueOf(date.getYear()));

        log.info("학과 DTO 검증 -- ");
        if(!departmentDTO.isValid()){
            log.info("학과 등록에 실패했습니다. DTO 문제");
            return "redirect:/admin/college/register";
        }

        log.info("대학 정보 검증 -- ");

        // 등록
        departmentService.register(departmentDTO);

        return "redirect:/admin/college/register";
    }

    /**
     * API
     */

    /**
     * 학생 학적정보 입력 - 입학학과 정보 출력 
     */
    // 대학을 선택하면 관련 학과를 출력
    @ResponseBody
    @GetMapping("/api/list")
    public List<DepartmentDTO> departmentList(@RequestParam("college") String college){

        log.info( "college : " + "관련 학과를 출력 합니다.");
        List<DepartmentDTO> departmentDTOS = departmentService.findAllDepartmentByName(college);
        return departmentDTOS;
    }
}
