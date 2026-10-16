package kr.co.greendae.init;

import jakarta.annotation.PostConstruct;
import kr.co.greendae.dto.user.UserDTO;
import kr.co.greendae.entity.user.Role;
import kr.co.greendae.entity.user.Terms;
import kr.co.greendae.repository.user.TermsRepository;
import kr.co.greendae.repository.user.UserRepository;
import kr.co.greendae.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 로컬의 초기 데이터를 위한 클래스입니다.
 */
@Slf4j
@Profile("local")
@Component
@RequiredArgsConstructor
public class InitUser {

    private final TermsRepository termsRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        initUser();
    }

    @Transactional
    public void initUser(){

        if(!userRepository.existsById("admin")){
            UserDTO admin = UserDTO.builder()
                    .uid("admin")
                    .pass("1234")
                    .name("관리자")
                    .email("admin@naver.com")
                    .hp("010-1234-2512")
                    .role(Role.ADMIN)
                    .zip("12345")
                    .addr1("주소")
                    .addr2("상세주소")
                    .ssn("914712-1241752")
                    .ename("Admin")
                    .gender("male")
                    .nationality("한국")
                    .build();

            userService.register(admin);

        }

    }





}
