package com.neusoft.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.OrderAndCustomerVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.mapper.OrderHistoryMapper;
import com.neusoft.service.IOrderHistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 历史订单 历史订单 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/order-history")
public class OrderHistoryController {

    @Autowired
    private IOrderHistoryService orderHistoryService;

    @RequestMapping("/list/{cid}")
    public TableDataVo list(Page page, @PathVariable("cid") Integer cid){
        List<OrderAndCustomerVo> list = orderHistoryService.orderHis(page, cid);
        return TableDataVo.okData(page.getTotal(),list);
    }
}
