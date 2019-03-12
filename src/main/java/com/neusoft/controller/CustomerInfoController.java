package com.neusoft.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerInfo;
import com.neusoft.entity.vo.CustomerInfoVo;
import com.neusoft.entity.vo.SystemUserVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.ICustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 客户信息 客户信息 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/customer-info")
public class CustomerInfoController {

    @Autowired
    private ICustomerInfoService customerInfoService;

    @RequestMapping("/list")
    public TableDataVo list(Page page, @RequestParam(name="search" ,required = false) String search){
        List<CustomerInfoVo> list = customerInfoService.pagew(page, search);
        return TableDataVo.okData(page.getTotal(),list);
    }
    //获取所有客户（by meng）
    @RequestMapping("/customer-all")
    public List<CustomerInfo> getAllCustomer(){//获取到所有客户
        List<CustomerInfo> list = customerInfoService.list();

        return list;
    }

    //获取客户byId（by MENG）
    @RequestMapping("/getCustomer/{id}")
    public CustomerInfo getCustomer(@PathVariable("id") Integer id){
        CustomerInfo customerInfo = customerInfoService.getById(id);
        System.out.println(customerInfo);
        return customerInfo;
    }

    @RequestMapping("/edit")
    public TableDataVo edit(CustomerInfo info){
        boolean flg = customerInfoService.updateById(info);
        if(flg)
            return TableDataVo.okMsg("更新成功!!");
        return TableDataVo.failMsg("更新失败!!");
    }


}
