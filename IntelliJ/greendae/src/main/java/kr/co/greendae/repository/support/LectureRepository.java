package kr.co.greendae.repository.support;

import com.querydsl.core.Tuple;
import kr.co.greendae.dto.support.LectureDTO;
import kr.co.greendae.entity.Lecture.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, String>{

}