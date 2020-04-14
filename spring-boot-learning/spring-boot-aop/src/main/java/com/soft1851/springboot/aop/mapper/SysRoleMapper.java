package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
public interface SysRoleMapper {

    /**
     * 根据角色id查询角色
     * @param roleId
     * @return
     */
    @Select("SELECT * FROM sys_role WHERE role_id=#{roleId}")
    Map<String, Object> getRoleById(int roleId);
}
