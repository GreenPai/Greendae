package kr.co.greendae.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.greendae.entity.user.Role;
import kr.co.greendae.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class UserRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired UserRepository repository;

    @Test
    void testPropertySources() {
        MockEnvironment environment = new MockEnvironment();
        TestPropertyValues.of("MAIL_USERNAME=clsrntkdgh@gmail.com", "MAIL_PASSWORD=bknbnddrgbfxgfim").applyTo(environment);
        assertThat(environment.getProperty("MAIL_USERNAME")).isEqualTo("clsrntkdgh@gmail.com");
    }

    @Test
    public void 유저테스트()  throws Exception{
        Optional<User> admin = repository.findById("admin");
        assertThat(admin.isPresent()).isTrue();
    }

    @Test
    public void 저장테스트() {
        User user = createUser();
        repository.save(user);

        em.flush();
        em.clear();

        Optional<User> savedUser = repository.findById("test1");
        if(savedUser.isPresent()){
            log.info(String.valueOf(savedUser.get()));
            assertThat(savedUser.get().getRole()).isEqualTo(Role.STUDENT);
        }else {
            fail();
        }
    }

    @Test
    public void 수정테스트() {
        // 1. 테스트 데이터 생성 및 저장
        User user = createUser();
        repository.save(user);

        em.flush();
        em.clear();

        // 2. 저장된 사용자 조회
        User savedUser = repository.findById("test1")
                .orElseThrow();

        // 3. 데이터 수정
        savedUser.setName("김철수");
        savedUser.setEmail("kim@example.com");

        em.flush();
        em.clear();

        // 4. 수정 결과 재조회
        User updatedUser = repository.findById("test1")
                .orElseThrow();

        // 5. 수정 결과 검증
        assertThat(updatedUser.getName()).isEqualTo("김철수");
        assertThat(updatedUser.getEmail()).isEqualTo("kim@example.com");
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
}