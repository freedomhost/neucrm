package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    List<OrderInfo> list(Page page, Integer cid);
}
