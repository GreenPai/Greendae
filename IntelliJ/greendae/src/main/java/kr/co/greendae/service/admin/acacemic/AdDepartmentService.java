package kr.co.greendae.service.admin.acacemic;

import com.querydsl.core.Tuple;
import kr.co.greendae.dto.department.DepartmentDTO;
import kr.co.greendae.dto.department.PageDepartmentRequestDTO;
import kr.co.greendae.dto.department.PageDepartmentResponseDTO;
import kr.co.greendae.entity.college.College;
import kr.co.greendae.entity.department.Department;
import kr.co.greendae.repository.department.CollegeRepository;
import kr.co.greendae.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class AdDepartmentService {

    private final ModelMapper modelMapper;

    private final DepartmentRepository departmentRepository;
    private final CollegeRepository collegeRepository;

    public void register(DepartmentDTO departmentDTO) {

        Optional<College> optCollege = collegeRepository.findById(departmentDTO.getCollegeName());

        if(optCollege.isEmpty()){
            log.info("존재 하지 않는 대학입니다.");
        }

        Department department = modelMapper.map(departmentDTO, Department.class);
        department.setCollege(optCollege.get());
        log.info("department" + String.valueOf(department));

        departmentRepository.save(department);
    }

    public PageDepartmentResponseDTO findAllDepartment(PageDepartmentRequestDTO pageDepartmentRequestDTO) {

        // 페이징 처리를 위한 pageable 객체 생성
        Pageable pageable = pageDepartmentRequestDTO.getPageable("no");

        Page<Tuple> pageDepartment = departmentRepository.selectAllForList(pageable);

        // Article Entity 리스트를 ArticleDTO 리스트로 변환
        List<DepartmentDTO> departmentDTOS = pageDepartment.getContent().stream().map(tuple -> {

            Department department = tuple.get(0, Department.class);

            DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);

            return departmentDTO;

        }).toList();

        int total = (int) pageDepartment.getTotalElements();

        return PageDepartmentResponseDTO
                .builder()
                .pageRequestDTO(pageDepartmentRequestDTO)
                .dtoList(departmentDTOS)
                .total(total)
                .build();
    }

    public List<DepartmentDTO> findAllDepartmentByName(String name) {

        List<Department> departments = departmentRepository.findAllByCollege_Name(name);
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        for (Department department : departments) {
            DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
            departmentDTOS.add(departmentDTO);
        }

        return departmentDTOS;
    }

    /**
     * 부서 이름 찾기
     */
    public DepartmentDTO findDepartmentById(int id) {
        // 수정 이름아님 -> PK로 찾기
        Department department = departmentRepository.findById(id).get();
        return modelMapper.map(department, DepartmentDTO.class);
    }


    

}
