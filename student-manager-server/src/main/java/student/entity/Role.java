package student.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * (Role)实体类
 *
 * @author hui
 * @date 2022-01-08 10:15:39
 */
@Data
@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = -36119020999948601L;
    /**
     * 角色ID
     */     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    /**
     * 角色名称
     */     
    private String name;
    /**
     * 角色备注
     */     
    private String remark;

}

