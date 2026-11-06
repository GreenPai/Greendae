package kr.co.greendae.repository.support;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.greendae.entity.Lecture.Lecture;
import kr.co.greendae.entity.Lecture.Subject;
import kr.co.greendae.entity.Lecture.SubjectType;
import kr.co.greendae.entity.user.Professor;
import kr.co.greendae.entity.user.User;
import kr.co.greendae.repository.subject.SubjectRepository;
import kr.co.greendae.repository.user.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class LectureRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ProfessorRepository professorRepository;

    private Subject subject;
    private Professor professor;

    @BeforeEach
    public void setUp(){
        subject = Subject.builder()
                .title("자바 프로그래밍")
                .code("TT101")
                .credits(3)
                .type(SubjectType.MAJOR_REQUIRED)
                .build();

        subjectRepository.save(subject);

        User user= User.builder().uid("admin").build();

        professor = Professor.builder().user(user)
                .proNo("20")
                .build();

        professorRepository.save(professor);

    }

    @Test
    public void 등록_테스트(){
        Lecture lecture = Lecture.builder()
                .lecNo("CN102")
                .professor(professor)
                .subject(subject)
                .lecMajor("전공")
                .lecClass("1분반")
                .lecGrade(1)
                .lecCredit(3)
                .lecStdTotal(50)
                .lecStdCount(0)
                .lecLevel(3)
                .lecRoom("강의실1")
                .lecWeekday("월요일")
                .lecScheduleStart("03/02/26")
                .lecScheduleEnd("06/20/26")
                .lecTimeStart("09:00")
                .lecTimeEnd("10:30")
                .book("출판사 - 자바 프로그래밍 - 홍길동")
                .lecContent("자바 프로그래밍 기초 강의")
                .lecEvaluation("중간고사 40%, 기말고사 40%, 출석 20%")
                .build();

        Lecture saveLecture = lectureRepository.save(lecture);

        log.info("saveLecture = {}" , saveLecture);

    }







}