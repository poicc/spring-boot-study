package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author CRQ
 */
@Data
public class Rank {
    @TableId(value = "user_id",type = IdType.INPUT)
    private Integer id;
    private String author;
    private String pic;
    private String title;
    private String duration;
}
