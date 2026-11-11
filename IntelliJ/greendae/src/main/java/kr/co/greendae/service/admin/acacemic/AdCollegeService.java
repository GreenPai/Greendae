package kr.co.greendae.service.admin.acacemic;

import kr.co.greendae.dto.college.CollegeDTO;
import kr.co.greendae.entity.college.College;
import kr.co.greendae.repository.department.CollegeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class AdCollegeService {

    private final CollegeRepository collegeRepository;
    private final ModelMapper modelMapper;

    public List<CollegeDTO> findAllCollege() {

        List<College> collegeList = collegeRepository.findAll();
        List<CollegeDTO> collegeDTOS = new ArrayList<>();
        for (College college : collegeList) {
            CollegeDTO collegeDTO = modelMapper.map(college, CollegeDTO.class);
            collegeDTOS.add(collegeDTO);
        }
        return collegeDTOS;
    }

    public void save(CollegeDTO collageDTO) {

        College college = modelMapper.map(collageDTO, College.class);
        collegeRepository.save(college);
    }

    public boolean existsCollegeByName(String name) {
        return collegeRepository.existsById(name);
    }
}
