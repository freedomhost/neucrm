package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.OrderHistory;
import com.neusoft.entity.vo.OrderAndCustomerVo;
import com.neusoft.mapper.OrderHistoryMapper;
import com.neusoft.service.IOrderHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 历史订单 历史订单 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class OrderHistoryServiceImpl extends ServiceImpl<OrderHistoryMapper, OrderHistory> implements IOrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderAndCustomerVo>  orderAndLoss() {
        List<OrderAndCustomerVo> list = orderHistoryMapper.orderAndLoss();
        return list;
    }

    @Override
    public List<OrderAndCustomerVo> newTime(Integer id) {
     List<OrderAndCustomerVo> list = orderHistoryMapper.newTime(id);
        return list;
    }

    @Override
    public List<OrderAndCustomerVo> orderHis(Page page, Integer cid) {
        List<OrderAndCustomerVo> list = orderHistoryMapper.orderHis(page,cid);
        return list;
    }
}
