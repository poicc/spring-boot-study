package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RolePermission)实体类
 *
 * @author makejava
 * @since 2020-04-13 19:51:02
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 270567046211088726L;
    /**
    * id
    */
    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 权限id
    */
    private Integer permissionId;

}