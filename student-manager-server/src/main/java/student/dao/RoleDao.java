package student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import student.entity.Role;

/**
 * (Role)表数据库访问层
 *
 * @author hui
 * @date 2022-01-08 10:15:39
 */
public interface RoleDao extends JpaRepository<Role,Integer> {

}

