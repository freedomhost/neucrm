package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerLoss;
import com.neusoft.entity.OrderHistory;
import com.neusoft.entity.vo.CustomerLossVo;
import com.neusoft.entity.vo.OrderAndCustomerVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.ICustomerLossService;
import com.neusoft.service.IOrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 客户流失 客户流失 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/customer-loss")
public class CustomerLossController {

    @Autowired
    private ICustomerLossService customerLossService;

    @Autowired
    private IOrderHistoryService orderHistoryService;

    @RequestMapping("/loss")
    public TableDataVo list(Page page, @RequestParam(name = "customer", required = false) String customer
            , @RequestParam(name = "manager", required = false) String manager, @RequestParam(name = "status", required = false) String status) {
        List<CustomerLossVo> list = customerLossService.pages(page, customer, manager, status);
        return TableDataVo.okData(page.getTotal(), list);
    }

    @RequestMapping("/edit")
    public TableDataVo edit(CustomerLoss loss) {
        // System.out.println(loss);
        boolean flg = customerLossService.updateById(loss);
        if (flg)
            return TableDataVo.okMsg("追加暂缓措施成功!!");
        return TableDataVo.failMsg("失败!!");
    }

    @RequestMapping("/edit1")
    public TableDataVo edit1(CustomerLoss loss) {
//        System.out.println("!!!!"+loss);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//         String t = df.format(new Date());// new Date()为获取当前系统时间
//       //字符串转时间
        long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();//获取当前系统时间
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(l / 1000, 0, ZoneOffset.ofHours(8));
        loss.setLossTime(dateTime);//自动添加流失时间为当前操作时间
        loss.setStatus(1);   //自动将状态更新为确认流失
        boolean flg = customerLossService.updateById(loss);
        if (flg)
            return TableDataVo.okMsg("确认流失!!");
        return TableDataVo.failMsg("失败!!");
    }

    @RequestMapping("/edit2")
    public TableDataVo edit2(CustomerLoss loss) {
        // System.out.println(loss);
        loss.setStatus(0);
        boolean flg = customerLossService.updateById(loss);
        if (flg)
            return TableDataVo.okMsg("更新成功!!");
        return TableDataVo.failMsg("更新失败!!");
    }

    @RequestMapping("/creat")
    public TableDataVo creat() {
        TableDataVo tableDataVo = null;
        CustomerLoss loss = new CustomerLoss();
        List<OrderAndCustomerVo> list = orderHistoryService.orderAndLoss();//查询未流失的客户信息
        for (OrderAndCustomerVo d : list) {
            List<OrderAndCustomerVo> list1 = orderHistoryService.newTime(d.getCustomerId());//查询客户最新订单信息
            for (OrderAndCustomerVo t : list1) {
                LocalDateTime orderTime = t.getOrderTime();//获取订单时间
                int year = orderTime.getYear();//获取订单年数
                int month = orderTime.getMonthValue();//获取订单月份
                long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();//获取当前系统时间
                LocalDateTime dateTime = LocalDateTime.ofEpochSecond(l / 1000, 0, ZoneOffset.ofHours(8));
                int y = dateTime.getYear();
                int m = dateTime.getMonthValue();
                int a = y - year, b = m - month;
                if (a * 12 + b > 6) {
                    loss.setStatus(2);
                    loss.setLastOrderTime(orderTime);
                    loss.setCustomerId(d.getCustomerId());
                    loss.setCustomerMgr(d.getCustomerMgr());
                    loss.setCustomerName(d.getCustomerName());
                    boolean flg = customerLossService.save(loss);
                    if (flg) {
                        tableDataVo = TableDataVo.okMsg("客户流失预警!!");
                    }else {
                        tableDataVo = TableDataVo.failMsg("该系统思想出问题了,请联系系统管理员!!");
                    }
                }
            }


        }

            return tableDataVo;
    }
}
