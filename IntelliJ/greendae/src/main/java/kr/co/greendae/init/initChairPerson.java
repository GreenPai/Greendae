package kr.co.greendae.init;

import jakarta.annotation.PostConstruct;
import kr.co.greendae.entity.department.Chairperson;
import kr.co.greendae.entity.user.Terms;
import kr.co.greendae.repository.department.ChairPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

//        if(!chairPersonRepository.existsById(1)){
//            chairPersonRepository.saveAll(List.of(
//                    new Chairperson("김국어"),
//                    new Chairperson("김영어"),
//                    new Chairperson("김일어"),
//                    new Chairperson("김중어"),
//                    new Chairperson("김역사"),
//                    new Chairperson("김경제"),
//                    new Chairperson("김법학"),
//                    new Chairperson("김철학"),
//                    new Chairperson("김행정"),
//                    new Chairperson("김사회")
//            ));
//        }
    }


}
