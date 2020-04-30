package com.soft1851.springboot.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.springboot.mbp.model.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crq
 * @since 2020-04-16
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    @Select("SELECT t1.*, t2.* " +
            "FROM user_role t3 " +
            "LEFT JOIN sys_user t1 " +
            "ON t1.user_id = t3.user_id " +
            "LEFT JOIN sys_role t2 " +
            "ON t2.role_id = t3.role_id " +
            "WHERE t3.user_id=#{userId}")
    Map<String,Object> getUserById(String userId);

    /**
     * 登陆
     * @param userId
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE user_id=#{userId}")
    SysUser signIn(String userId);

}
