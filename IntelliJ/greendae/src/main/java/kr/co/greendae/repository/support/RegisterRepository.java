package kr.co.greendae.repository.support;

import kr.co.greendae.entity.Lecture.Lecture;
import kr.co.greendae.entity.Lecture.Register;
import kr.co.greendae.entity.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface RegisterRepository extends JpaRepository<Register, Integer>  {

}