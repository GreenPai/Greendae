package kr.co.greendae.repository.support;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.greendae.entity.Lecture.Subject;
import kr.co.greendae.entity.Lecture.SubjectType;
import lombok.extern.slf4j.Slf4j;
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

    /**
     * 과목 데이터 생성 메서드
     */
    private static Subject createSubject() {

        log.info(SubjectType.GENERAL.getDescription());

        return Subject.builder()
                .title("자바 프로그래밍")
                .code("TT101")
                .credits(3)
                .type(SubjectType.MAJOR_REQUIRED)
                .build();
    }




}