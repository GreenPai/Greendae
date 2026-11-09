package kr.co.greendae.controller.admin.academic;

import kr.co.greendae.dto.department.DepartmentDTO;
import kr.co.greendae.dto.department.PageDepartmentRequestDTO;
import kr.co.greendae.dto.department.PageDepartmentResponseDTO;
import kr.co.greendae.service.AdminService;
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

    private final AdminService adminService;

    @GetMapping("/list")
    public String departmentList(Model model, PageDepartmentRequestDTO pageDepartmentRequestDTO){

        // 전체 학과 조회 서비스 호출(JPA)
        PageDepartmentResponseDTO pageDepartmentResponseDTO = adminService.findAllDepartment(pageDepartmentRequestDTO);

        System.out.println("--------");
        System.out.println("pageDepartmentResponseDTO = " + pageDepartmentResponseDTO);

        model.addAttribute("pageResponseDTO",pageDepartmentResponseDTO);
        return "/admin/list/department";
    }

    @PostMapping("/register")
    public String department(DepartmentDTO departmentDTO,
                             @RequestParam("date")
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){

        log.info("register 실행합니다.");

        departmentDTO.setEstablishedYear(String.valueOf(date.getYear()));
//
//        if(!departmentDTO.isValid()){
//            log.info("학과 등록에 실패했습니다.");
//            return "redirect:/admin/college/register";
//        }
//
//        // 최신 학과번호 추출
//        int deptNo = adminService.getMaxDepNo();
//        departmentDTO.setDeptNo(deptNo);
//
//        // 등록
//        adminService.register(departmentDTO);

        return "redirect:/admin/college/register";
    }

    /**
     * API
     */

    // 대학을 선택하면 관련 학과를 출력
    @ResponseBody
    @GetMapping("/api/list")
    public List<DepartmentDTO> departmentList(@RequestParam("college") String college){
        List<DepartmentDTO> departmentDTOS = adminService.findAllDepartmentByName(college);
        return departmentDTOS;
    }
}
