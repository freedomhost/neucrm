package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.*;
import com.neusoft.entity.vo.SaleDrawPlanVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.ICustomerContactService;
import com.neusoft.service.ICustomerInfoService;
import com.neusoft.service.IDrawPlanService;
import com.neusoft.service.ISalesOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 制定计划 制定计划 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/draw-plan")
public class DrawPlanController {
    @Autowired
    private IDrawPlanService userService;
    @Autowired
    private ICustomerInfoService iCustomerInfoService;
    @Autowired
    private ISalesOpportunityService iSalesOpportunityService;
    @Autowired
    private ICustomerContactService iCustomerContactService;

    private SalesOpportunity salesOpportunity=new SalesOpportunity();
    private CustomerContact customerContact=new CustomerContact();
    private SystemUser systemUser=new SystemUser();

    @RequestMapping("/getuser/{assignName}")
    public TableDataVo getuser(@PathVariable("assignName") String assignName){
        systemUser=userService.su(assignName);
        if(systemUser!=null) {
            return TableDataVo.okData(systemUser);
        }
        return TableDataVo.failMsg("开发失败！！");
    }

    @RequestMapping("/developFail/{opportunityId}")
    public TableDataVo developFail(@PathVariable("opportunityId") Integer opportunityId){
        salesOpportunity.setId(opportunityId);
        salesOpportunity.setStatus(3);
        boolean flg =iSalesOpportunityService.updateById(salesOpportunity);
        if(flg){
            return TableDataVo.okMsg("开发完成!!");
        }
        return TableDataVo.failMsg("开发失败！！");
    }
    @RequestMapping("/developSuccess")
    public TableDataVo developSuccess( CustomerInfo customerInfo){
        int customerId=Integer.valueOf(customerInfo.getFax());
        salesOpportunity.setId(customerId);
        salesOpportunity.setStatus(2);
        boolean flg =iSalesOpportunityService.updateById(salesOpportunity);

        customerInfo.setFax("");
        boolean ci= iCustomerInfoService.save(customerInfo);

        SalesOpportunity salesOpportunity1=userService.so(customerId);
        customerContact.setName(salesOpportunity1.getContacts());
        String tel= String.valueOf(salesOpportunity1.getContactsTel());
        customerContact.setTel(tel);
        CustomerContact customerContact2=userService.cc(salesOpportunity1.getName());
        customerContact.setCustomerId(customerContact2.getCustomerId());
        boolean flg1=iCustomerContactService.save(customerContact);
        if(ci&&flg&&flg1){
            return TableDataVo.okMsg("开发成功!!");
        }
        return TableDataVo.failMsg("开发失败！！");
    }


    @RequestMapping("/looklist/{opportunityId}")
    public TableDataVo looklist(Page page, @PathVariable("opportunityId") Integer opportunityId){
        List<DrawPlan> list = userService.dpPage(page, opportunityId);
        return TableDataVo.okData(page.getTotal(),list);
    }

    @PostMapping("/deldraw/{id}")
    public TableDataVo deldraw(@PathVariable("id") Integer id){
        boolean flg = userService.removeById(id);
        if(flg){
            return TableDataVo.okMsg("删除成功！！");
        }
        return TableDataVo.failMsg("删除失败！！");
    }

    @PostMapping("/delsale/{id}")
    public TableDataVo delsale(@PathVariable("id") Integer id){
        boolean flg = iSalesOpportunityService.removeById(id);
        if(flg){
            return TableDataVo.okMsg("删除成功！！");
        }
        return TableDataVo.failMsg("删除失败！！");
    }

    @RequestMapping(value = "/edit")
    public TableDataVo edit(DrawPlan dp){
        boolean flg = userService.updateById(dp);
        System.out.println(flg);
        if(flg)
            return TableDataVo.okMsg("更新成功!!");
        return TableDataVo.failMsg("更新失败!!");
    }

    @PostMapping("/save-edit")
    public TableDataVo saveOrEdit(DrawPlan drawPlan){
        boolean flg = userService.save(drawPlan);
        if(flg){
            return TableDataVo.okMsg("新建计划项成功！！");
        }
        return TableDataVo.failMsg("新建计划项失败！！");
    }

    @RequestMapping("/list")
    public TableDataVo list(Page page, @RequestParam(value = "search",required = false) String search){
        List<SaleDrawPlanVo> list = userService.sdpvPage(page, search);
        return TableDataVo.okData(page.getTotal(),list);
    }
}
