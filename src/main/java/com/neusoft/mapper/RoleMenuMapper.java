package com.neusoft.mapper;

import com.neusoft.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.vo.RoleMenuVo;

import java.util.List;

/**
 * <p>
 * 角色菜单关系表 角色菜单关系表 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenuVo> {
    List<RoleMenuVo> menuByRoleId(Integer roleId);
}
