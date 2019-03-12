package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerLoss;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.CustomerLossVo;

import java.util.List;

/**
 * <p>
 * 客户流失 客户流失 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface ICustomerLossService extends IService<CustomerLoss> {
  List<CustomerLossVo> pages(Page page,String customer,String manager,String status);
}
