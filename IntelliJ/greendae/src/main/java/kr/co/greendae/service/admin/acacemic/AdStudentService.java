package kr.co.greendae.service.admin.acacemic;

import com.querydsl.core.Tuple;
import kr.co.greendae.dto.page.PageRequestDTO;
import kr.co.greendae.dto.support.StudentDTO;
import kr.co.greendae.dto.user.PageStudentResponseDTO;
import kr.co.greendae.entity.user.Student;
import kr.co.greendae.repository.user.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdStudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public PageStudentResponseDTO findAllStudent(PageRequestDTO pageRequestDTO) {

        // 페이징 처리를 위한 pageable 객체 생성
        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Tuple> pageStudent = studentRepository.selectAllForList(pageable);

        // Article Entity 리스트를 ArticleDTO 리스트로 변환
        List<StudentDTO> studentDTOS = pageStudent.getContent().stream().map(tuple -> {

            Student student = tuple.get(0, Student.class);

            StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

            return studentDTO;

        }).toList();

        int total = (int) pageStudent.getTotalElements();

        return PageStudentResponseDTO
                .builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(studentDTOS)
                .total(total)
                .build();


    }

}
