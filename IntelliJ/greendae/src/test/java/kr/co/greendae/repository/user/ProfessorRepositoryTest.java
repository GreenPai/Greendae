package kr.co.greendae.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.greendae.entity.department.Department;
import kr.co.greendae.entity.user.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class ProfessorRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfessorRepository professorRepository;

    /**
     * 교수과 유저 생명주기를 같게하여
     * 유저 정보를 저장하면 교수도 동시에 저장.
     */
    @Test
    public void 교수저장테스트(){
        User user = createUser();
        Professor professor = createProfessor(user,null);
        user.setProfessor(professor);

        userRepository.save(user);

        em.flush();
        em.clear();

        Professor pro = professorRepository.findById("P20260001").orElseThrow();
        log.info(String.valueOf(pro));

        em.flush();
        em.clear();
        User findUser = userRepository.findById("test1").orElseThrow();
        log.info(String.valueOf(findUser));

    }

    /**
     * 교수와 유저 생명주기를 같게하여
     * 유저 정보를 저장하면 교수도 동시에 삭제.
     */
    @Test
    public void 교수삭제테스트(){
        User user = createUser();
        Professor professor = createProfessor(user,null);
        user.setProfessor(professor);

        userRepository.save(user);

        em.flush();
        em.clear();

        Professor st = professorRepository.findById("P20260001").orElseThrow();
        log.info(String.valueOf(st));

        em.flush();
        em.clear();
        userRepository.deleteById("test1");

        Optional<Professor> optStudent = professorRepository.findById("P20260001");

        if(optStudent.isPresent()){
            log.info(String.valueOf(optStudent.get()));
            Assertions.fail();
        }

    }
    
    /**
     * 유저 정보 저장
     */
    static User createUser(){
        return User.builder()
                .uid("test1")
                .pass("test1234")
                .name("홍길동")
                .email("test1@example.com")
                .hp("010-1234-5678")
                .regip("127.0.0.1")
                .addr1("부산광역시 부산진구")
                .addr2("101동 202호")
                .ssn("000000-0000000")
                .ename("Hong Gil Dong")
                .gender("남")
                .nationality("대한민국")
                .zip("47200")
                .role(Role.STUDENT)
                .build();
    }

    /**
     * 교수 정보 저장
     */
    public static Professor createProfessor(User user, Department department) {
        return Professor.builder()
                .proNo("P20260001")           // 교수번호 (예시)
                .user(user)                  // 유저 객체 연결
                .department(department)      // 학과 객체 연결
                .appointmentDate("2026-03-01") // 임용일
                .graduationDate("2015-02-28")  // 졸업일
                .graduationSchool("대학교")  // 졸업대학
                .degree("박사")               // 학위
                .status("재직중")             // 재직상태
                .position(Position.PROFESSOR) // 직위
                .build();
    }
}