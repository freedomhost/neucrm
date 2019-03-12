package com.neusoft.service.impl;

import com.neusoft.entity.Menu;
import com.neusoft.entity.RoleMenu;
import com.neusoft.entity.SystemUser;
import com.neusoft.entity.vo.RoleMenuVo;
import com.neusoft.entity.vo.SystemUserVo;
import com.neusoft.mapper.MenuMapper;
import com.neusoft.mapper.RoleMenuMapper;
import com.neusoft.mapper.SystemUserMapper;
import com.neusoft.service.ISystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统用户 系统用户 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {
    @Autowired
    private SystemUserMapper mapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<SystemUserVo> getCustomerMgr() {
        return  mapper.getCustomerMgr();
    }

    @Override
    public SystemUserVo getUserVoById(Integer id) {
        return mapper.getUserVoById(id);
    }

    @Override
    public List<RoleMenuVo> selMenus(SystemUserVo user) {
        List<RoleMenuVo> results = new ArrayList<>();
        Integer roleId = user.getRoleId();

/*        TbRolesMenusExample example = new TbRolesMenusExample();
        com.irs.pojo.TbRolesMenusExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<TbRolesMenusKey> list = tbRolesMenusMapper.selectByExample(example);*/
        List<RoleMenuVo> list = roleMenuMapper.menuByRoleId(roleId);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getParentId() == 0) {
                    RoleMenuVo menu = new RoleMenuVo();
                    menu.setMeunName(list.get(i).getMeunName());
                    menu.setMenuIcon(list.get(i).getMenuIcon());
                    menu.setHref(list.get(i).getHref());
                    menu.setIsSpread(list.get(i).getIsSpread());
                    List<RoleMenuVo> list2 = new ArrayList<>();
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getParentId() == list.get(i).getMenuId()) {
                            RoleMenuVo menu2 = new RoleMenuVo();
                            menu2.setMeunName(list.get(j).getMeunName());
                            menu2.setMenuIcon(list.get(j).getMenuIcon());
                            menu2.setHref(list.get(j).getHref());
                            menu2.setIsSpread(list.get(j).getIsSpread());
                            list2.add(menu2);
                        }
                    }
                    menu.setChildren(list2);
                    results.add(menu);
                }
            }
        }
        return results;
    }
}
