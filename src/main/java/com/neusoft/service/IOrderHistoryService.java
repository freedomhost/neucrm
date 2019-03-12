package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.OrderHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.OrderAndCustomerVo;

import java.util.List;

/**
 * <p>
 * 历史订单 历史订单 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IOrderHistoryService extends IService<OrderHistory> {
      List<OrderAndCustomerVo>  orderAndLoss();
      List<OrderAndCustomerVo>  newTime(Integer id);
      List<OrderAndCustomerVo> orderHis(Page page,Integer cid);
}
