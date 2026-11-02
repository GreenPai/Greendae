package kr.co.greendae.service;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.querydsl.core.Tuple;

import kr.co.greendae.dto.support.LectureDTO;
import kr.co.greendae.dto.support.RecordDTO;
import kr.co.greendae.dto.support.RegisterDTO;

import kr.co.greendae.dto.support.StudentDTO;
import kr.co.greendae.dto.support.pageRegister.PageRequestDTO;
import kr.co.greendae.dto.support.pageRegister.PageResponseDTO;
import kr.co.greendae.dto.support.pageRegisterList.RegisteredPageRequestDTO;
import kr.co.greendae.dto.support.pageRegisterList.RegisteredPageResponseDTO;
import kr.co.greendae.entity.Lecture.Lecture;
import kr.co.greendae.entity.Lecture.Register;
import kr.co.greendae.entity.user.Professor;
import kr.co.greendae.entity.user.Student;
import kr.co.greendae.repository.support.LectureRepository;
import kr.co.greendae.repository.support.RegisterRepository;

import kr.co.greendae.repository.user.ProfessorRepository;
import kr.co.greendae.repository.user.StudentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class SupportService {

    private final LectureRepository lectureRepository;
    private final RegisterRepository registerRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


}