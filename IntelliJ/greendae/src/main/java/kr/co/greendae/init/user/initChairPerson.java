package kr.co.greendae.init.user;

import jakarta.annotation.PostConstruct;
import kr.co.greendae.repository.department.ChairPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 로컬의 초기 데이터를 위한 클래스입니다.
 * 학과장 데이터
 */
@Slf4j
@Profile("local")
@Component
@RequiredArgsConstructor
public class initChairPerson {

    private final ChairPersonRepository chairPersonRepository;

    @PostConstruct
    public void init(){
        InitChairPerson();
    }

    @Transactional
    public void InitChairPerson(){

    }


}
