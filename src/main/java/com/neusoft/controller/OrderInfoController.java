package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.OrderInfo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.IOrderInfoService;
import com.neusoft.service.impl.OrderInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/order-info")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderInfoService;
    @RequestMapping("/list/{cid}")
    public TableDataVo list(Page page, @PathVariable("cid") Integer cid){
        List<OrderInfo> list = orderInfoService.list(page, cid);
        return TableDataVo.okData(page.getTotal(),list);
    }

}
