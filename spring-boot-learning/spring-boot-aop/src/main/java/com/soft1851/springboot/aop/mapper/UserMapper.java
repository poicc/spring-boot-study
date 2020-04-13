package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.Role;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * @author CRQ
 */
public interface UserMapper {
    /**
     * 查询所有
     * @return List</Map>
     */
    @Select("SELECT * FROM t_role")
    @Results({
            @Result(id=true,property="id",column="id",javaType = Integer.class),
            @Result(property="username",column="username",javaType = String.class),
            @Result(property = "isAdmin",column="is_admin",javaType=Boolean.class)
    })
    List<Role> selectAll();

    /**
     * 根据Id查询
     * @param id
     * @return
     * @throws SQLException
     */
    @Select("SELECT is_admin FROM t_role WHERE id=#{id}")
    Role selectAdminById(String id) throws SQLException;
}
