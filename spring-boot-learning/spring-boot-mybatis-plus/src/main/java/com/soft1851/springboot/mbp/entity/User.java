package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CRQ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(value = "user_id",type = IdType.INPUT)
    private Integer userId;
    private String username;
    private String password;
}
