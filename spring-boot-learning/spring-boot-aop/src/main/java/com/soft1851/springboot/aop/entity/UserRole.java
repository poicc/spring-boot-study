package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (UserRole)实体类
 *
 * @author makejava
 * @since 2020-04-13 19:51:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRole implements Serializable {
    private static final long serialVersionUID = 792615456912650139L;
    /**
    * 用户角色
    */
    private Integer id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 角色id
    */
    private Integer roleId;
}