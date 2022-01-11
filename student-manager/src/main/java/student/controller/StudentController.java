package student.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import student.dao.StudentDao;
import student.entity.Student;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生信息表(Student)表控制层
 *
 * @author hui
 * @date 2022-01-03 19:55:32
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentDao studentDao;

    /**
     * 动态模糊查询学生列表
     *
     * @param param 查询参数
     * @return Student集合对象
     */
    @GetMapping("/list")
    public Page<Student> list(Student param, int page, int size) {
        //分页条件
        Pageable pageable = PageRequest.of(page, size);
        //查询条件
        Specification<Student> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (param.getCollegeName() != null) {
                predicates.add(builder.like(root.get("collegeName"), "%" + param.getCollegeName() + "%"));
            }
            if (param.getClassName() != null) {
                predicates.add(builder.like(root.get("className"), "%" + param.getClassName() + "%"));
            }
            if (param.getStudentId() != null) {
                predicates.add(builder.like(root.get("studentId"), "%" + param.getStudentId() + "%"));
            }
            if (param.getRealName() != null) {
                predicates.add(builder.like(root.get("realName"), "%" + param.getRealName() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };

        return studentDao.findAll(specification,pageable);
    }

    /**
     * 添加/修改学生信息
     *
     * @param student Student对象
     * @return true/false
     */
    @PostMapping("/save")
    public boolean save(@RequestBody Student student) {
        if (student.getId() != null) {
            Student dbStudent = studentDao.getById(student.getId());
            student.setCreateTime(dbStudent.getCreateTime());
        }
        studentDao.save(student);
        return true;
    }

    /**
     * 查询学院列表
     *
     * @return 学院集合对象
     */
    @GetMapping("/colleges")
    public List<String> colleges() {
        return studentDao.listColleges();
    }

    /**
     * 根据学院查询班级列表
     *
     * @param collegeName 学院名称
     * @return 班级集合对象
     */
    @GetMapping("/classes")
    public List<String> classes(String collegeName) {
        return studentDao.listClasses(collegeName);
    }

}

