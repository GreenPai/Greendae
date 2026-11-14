package kr.co.greendae.controller.admin.academic;

import kr.co.greendae.dto.college.CollegeDTO;
import kr.co.greendae.service.admin.ImageService;
import kr.co.greendae.service.admin.acacemic.AdCollegeService;
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
@RequestMapping("/admin/college")
public class CollegeController {

//    private final AdminService adminService;
    private final AdCollegeService collegeService;
    private final ImageService imageService;


    // 대학 및 학과 등록 페이지
    @GetMapping("/register")
    public String college(Model model){

        List<CollegeDTO> collegeDTOS = collegeService.findAllCollege();
        model.addAttribute("collegeDTOS",collegeDTOS);

        //List<ChairPersonDTO> chairPersonDTOS = adminService.findAllChairPerson();
        //model.addAttribute("chairPersonDTOS",chairPersonDTOS);

        return "/admin/register/college";
    }

    @PostMapping("/register")
    public String college(CollegeDTO collageDTO){

        log.info("college register : collageDTO={}", collageDTO);

        // 만약 정보가 정확하지 않을 때 돌려보내기
        if(!collageDTO.isValid()){
            log.info("오류 발생");
            return "redirect:/admin/college/register";
        }

        // 이미지 등록 서비스 호출
        imageService.uploadImage(collageDTO);

        collegeService.save(collageDTO);

        return "redirect:/admin/college/register";
    }

}
