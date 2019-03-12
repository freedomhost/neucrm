package com.neusoft.service.impl;

import com.neusoft.entity.RoleMenu;
import com.neusoft.entity.vo.RoleMenuVo;
import com.neusoft.mapper.RoleMenuMapper;
import com.neusoft.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色菜单关系表 角色菜单关系表 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenuVo> implements IRoleMenuService {

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenuVo> menuByRoleId(Integer roleId) {
        return roleMenuMapper.menuByRoleId(roleId);
    }
}
