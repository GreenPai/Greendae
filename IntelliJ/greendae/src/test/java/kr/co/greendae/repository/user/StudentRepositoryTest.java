package kr.co.greendae.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.greendae.entity.department.Department;
import kr.co.greendae.entity.user.Professor;
import kr.co.greendae.entity.user.Role;
import kr.co.greendae.entity.user.Student;
import kr.co.greendae.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Slf4j
class StudentRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;

    /**
     * 학생과 유저 생명주기를 같게하여
     * 유저 정보를 저장하면 학생도 동시에 저장.
     */
    @Test
    public void 학생저장테스트(){
        User user = createUser();
        Student student = createStudent(user,null,null);
        user.setStudent(student);

        userRepository.save(user);

        em.flush();
        em.clear();

        Student st = studentRepository.findById("20261001").orElseThrow();
        log.info(String.valueOf(st));

        em.flush();
        em.clear();
        User findUser = userRepository.findById("test1").orElseThrow();
        log.info(String.valueOf(findUser));

    }

    /**
     * 학생과 유저 생명주기를 같게하여
     * 유저 정보를 저장하면 학생도 동시에 삭제.
     */
    @Test
    public void 학생삭제테스트(){
        User user = createUser();
        Student student = createStudent(user,null,null);
        user.setStudent(student);

        userRepository.save(user);

        em.flush();
        em.clear();

        Student st = studentRepository.findById("20261001").orElseThrow();
        log.info(String.valueOf(st));

        em.flush();
        em.clear();
        userRepository.deleteById("test1");

        Optional<Student> optStudent = studentRepository.findById("20261001");

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
     * 학생 정보 저장
     */
    static Student createStudent(User user, Department department, Professor professor) {
        return Student.builder()
                .stdNo("20261001")
                .user(user)
                .admission_year("2026")
                .graduation_year("2030")
                .admission_type("정시")
                .stdYear(1)
                .stdSemester("1학기")
                .registerCredits(18)
                .department(department)
                .stdClass("컴퓨터공학과")
                .professor(professor)
                .stdStatus("재학중")
                .build();
    }

}