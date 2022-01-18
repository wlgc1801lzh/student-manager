package student.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 学生信息表(Student)实体类
 *
 * @author hui
 * @date 2022-01-03 19:40:39
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student implements Serializable {
    private static final long serialVersionUID = -68522690625002333L;
    /**
     * 学生信息id，主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 学号
     */
    private String studentId;
    /**
     * 学院
     */
    private String collegeName;
    /**
     * 专业班级
     */
    private String className;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 创建时间
     */
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 学生类型
     */
    private Integer type;
}

