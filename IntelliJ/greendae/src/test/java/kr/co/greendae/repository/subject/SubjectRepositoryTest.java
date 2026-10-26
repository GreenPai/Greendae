package kr.co.greendae.repository.subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import kr.co.greendae.entity.Lecture.Subject;
import kr.co.greendae.entity.Lecture.SubjectType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * 과목 테스트
 */
@Slf4j
@Transactional
@SpringBootTest
class SubjectRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    SubjectRepository repository;

    private static Subject createSubject() {
        return Subject.builder()
                .title("자바 프로그래밍")
                .code("CS101")
                .credits(3)
                .type(SubjectType.MAJOR_REQUIRED)
                .build();
    }

    @Test
    public void 과목등록_테스트(){

        Subject subject = createSubject();

        Subject savedSubject = repository.save(subject); // 저장하면서 반환된 객체 활용

        em.flush();
        em.clear();

        Optional<Subject> optSubject = repository.findById(savedSubject.getId());

        log.info(String.valueOf(optSubject.get()));
        Assertions.assertThat(optSubject.get().getTitle()).isEqualTo("자바 프로그래밍");
    }


    @Test
    public void 과목삭제_테스트(){
        Subject subject = createSubject();

        Subject savedSubject = repository.save(subject); // 저장하면서 반환된 객체 활용

        em.flush();
        em.clear();
        int id = savedSubject.getId();
        repository.deleteById(id);
        Optional<Subject> optSubject = repository.findById(id);

        Assertions.assertThat(optSubject).isEmpty();
    }

}