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

import kr.co.greendae.entity.college.College;

/**
 * 대학 초기 데이터
 */
@Slf4j
@Profile("local")
@Component
@RequiredArgsConstructor
public class InitCollege {

    private final CollegeRepository repository;

    @PostConstruct
    public void init() {
        initCollege();
    }

    @Transactional
    public void initCollege() {

        // 데이터가 하나도 없을 때만 초기 데이터를 삽입합니다.
        if (repository.count() == 0) {

            List<College> colleges = List.of(
                    College.builder()
                            .name("인문대학")
                            .engName("College of Humanities")
                            .title("인문학의 가치를 탐구하는 대학")
                            .content("인간과 사회, 문화에 대한 깊이 있는 이해를 바탕으로 창의적인 인재를 양성합니다.")
                            .build(),

                    College.builder()
                            .name("사회과학대학")
                            .engName("College of Social Sciences")
                            .title("사회를 이해하고 미래를 설계하는 대학")
                            .content("사회 현상에 대한 분석과 연구를 통해 사회 발전에 기여하는 인재를 양성합니다.")
                            .build(),

                    College.builder()
                            .name("자연과학대학")
                            .engName("College of Natural Sciences")
                            .title("과학적 탐구와 창의적 연구")
                            .content("자연과학의 기초 학문을 연구하고 미래 과학기술을 이끌 인재를 양성합니다.")
                            .build(),

                    College.builder()
                            .name("공과대학")
                            .engName("College of Engineering")
                            .title("기술 혁신을 선도하는 공과대학")
                            .content("공학적 사고와 실무 역량을 갖춘 전문 기술 인재를 양성합니다.")
                            .build(),

                    College.builder()
                            .name("경영대학")
                            .engName("College of Business Administration")
                            .title("글로벌 경영 인재 양성")
                            .content("경영학적 지식과 실무 역량을 바탕으로 미래 사회를 이끌 인재를 양성합니다.")
                            .build()
            );

            repository.saveAll(colleges);

            log.info("초기 대학 데이터 {}건이 성공적으로 등록되었습니다.", colleges.size());
        }
    }
}