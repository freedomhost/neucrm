package com.neusoft.service;

import com.neusoft.entity.Menu;
import com.neusoft.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.RoleMenuVo;
import com.neusoft.entity.vo.SystemUserVo;

import java.util.List;

/**
 * <p>
 * 系统用户 系统用户 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface ISystemUserService extends IService<SystemUser> {
    List<SystemUserVo> getCustomerMgr();
    SystemUserVo getUserVoById(Integer id);

    List<RoleMenuVo> selMenus(SystemUserVo user);
}
