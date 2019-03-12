package com.neusoft.service;

import com.neusoft.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.RoleMenuVo;

import java.util.List;

/**
 * <p>
 * 角色菜单关系表 角色菜单关系表 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IRoleMenuService extends IService<RoleMenuVo> {
    List<RoleMenuVo> menuByRoleId(Integer roleId);
}
