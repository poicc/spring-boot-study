package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CRQ
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String id;
    private String username;
    private String isAdmin;
}
