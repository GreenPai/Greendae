package kr.co.greendae.init.college;

import jakarta.annotation.PostConstruct;
import kr.co.greendae.entity.Lecture.Subject;
import kr.co.greendae.entity.Lecture.SubjectType;
import kr.co.greendae.repository.department.CollegeRepository;
import kr.co.greendae.repository.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 과목 초기 데이터
 */
@Slf4j
@Profile("local")
@Component
@RequiredArgsConstructor
public class InitCollege {

    private final CollegeRepository repository;

    @PostConstruct
    public void init(){
        initSubjects();
    }

    @Transactional
    public void initSubjects(){
        // 데이터가 하나도 없을 때만 초기 데이터를 삽입합니다.
        if(repository.count() == 0){
            List<Subject> subjects = List.of(
                    Subject.builder().code("CS101").title("자바 프로그래밍").credits(3).type(SubjectType.MAJOR_REQUIRED).build(),
                    Subject.builder().code("CS102").title("자료구조").credits(3).type(SubjectType.MAJOR_REQUIRED).build(),
                    Subject.builder().code("CS201").title("데이터베이스").credits(3).type(SubjectType.MAJOR_REQUIRED).build(),
                    Subject.builder().code("CS202").title("스프링 프레임워크").credits(3).type(SubjectType.MAJOR_ELECTIVE).build(),
                    Subject.builder().code("CS301").title("웹 프로그래밍").credits(3).type(SubjectType.MAJOR_ELECTIVE).build(),
                    Subject.builder().code("GE101").title("대학 글쓰기").credits(2).type(SubjectType.GENERAL).build()
            );

            repository.saveAll(subjects);
            log.info("초기 과목 데이터 {}건이 성공적으로 등록되었습니다.", subjects.size());
        }
    }


}
