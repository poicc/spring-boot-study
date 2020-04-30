package com.soft1851.springboot.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.springboot.mbp.model.SysPermission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crq
 * @since 2020-04-16
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 通过id查询
     * @param id
     * @return
     */
    List<SysPermission> selectPermission (int id);
}
