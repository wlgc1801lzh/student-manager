package student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import student.entity.Student;

import java.util.List;

/**
 * @author hui
 * @date 2022-01-03 19:48:54
 */
public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

    @Query(nativeQuery = true, value = "select distinct college_name from student order by college_name")
    List<String> listColleges();

    @Query(nativeQuery = true, value = "select distinct class_name from student where college_name = ?1 order by class_name")
    List<String> listClasses(String collegeName);
}
