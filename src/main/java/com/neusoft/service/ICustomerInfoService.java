package com.neusoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.CustomerInfoVo;

import java.util.List;

/**
 * <p>
 * 客户信息 客户信息 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface ICustomerInfoService extends IService<CustomerInfo> {
    List<CustomerInfoVo> pagew(Page page, String search);
}
