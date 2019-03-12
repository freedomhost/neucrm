package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.ServiceUserAllot;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.ServiceUserAllotVo;

import java.util.List;

/**
 * <p>
 * 服务用户分配表 服务用户关系表 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IServiceUserAllotService extends IService<ServiceUserAllot> {
    List<ServiceUserAllotVo> servicePage(Page page, String search);
}
