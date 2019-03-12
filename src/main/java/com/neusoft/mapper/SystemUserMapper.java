package com.neusoft.mapper;

import com.neusoft.entity.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.vo.SystemUserVo;

import java.util.List;

/**
 * <p>
 * 系统用户 系统用户 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {
     List<SystemUserVo> getCustomerMgr();
     SystemUserVo getUserVoById(Integer id);
     Boolean updatePwd(Integer id);
}
