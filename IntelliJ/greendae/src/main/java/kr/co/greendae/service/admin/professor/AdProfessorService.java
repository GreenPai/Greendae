package kr.co.greendae.service.admin.professor;

import com.querydsl.core.Tuple;
import kr.co.greendae.dto.page.PageRequestDTO;
import kr.co.greendae.dto.user.PageProfessorResponseDTO;
import kr.co.greendae.dto.user.ProfessorDTO;
import kr.co.greendae.entity.user.Professor;
import kr.co.greendae.repository.user.ProfessorRepository;
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
public class AdProfessorService {

    private final ModelMapper modelMapper;
    private final ProfessorRepository professorRepository;

    public PageProfessorResponseDTO searchAllProfessor(PageRequestDTO pageRequestDTO) {

        // 페이징 처리를 위한 pageable 객체 생성
        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Tuple> pageObject = professorRepository.selectProfessorForSearch(pageRequestDTO, pageable);

        List<ProfessorDTO> professorDTOS = pageObject.getContent().stream().map(tuple -> {

            Professor professor = tuple.get(0, Professor.class);
            ProfessorDTO professorDTO = modelMapper.map(professor, ProfessorDTO.class);

            return professorDTO;

        }).toList();

        int total = (int) pageObject.getTotalElements();

        return PageProfessorResponseDTO
                .builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(professorDTOS)
                .total(total)
                .build();


    }


}
