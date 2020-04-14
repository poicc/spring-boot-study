package com.soft1851.springboot.aop.service;

import com.soft1851.springboot.aop.entity.RolePermission;
import java.util.List;
import java.util.Map;

/**
 * (RolePermission)表服务接口
 *
 * @author makejava
 * @since 2020-04-13 19:51:02
 */
public interface RolePermissionService {

    /**
     * 查询超管权限
     * @return
     */
    List<Map<String, Object>> getAdminRolePermission();

    /**
     * 查询系统管理员权限
     * @return
     */
    List<Map<String, Object>> getRolePermissionBySysAdmin(int sysAdminId);
}