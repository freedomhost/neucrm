package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.ServiceManagement;
import com.neusoft.entity.ServiceUserAllot;
import com.neusoft.entity.vo.ServiceUserAllotVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.IServiceUserAllotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务用户分配表 服务用户关系表 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/service-user-allot")
public class ServiceUserAllotController {

    @Autowired
    private IServiceUserAllotService iServiceUserAllotService;
    //分配好的form提交，增加一条serviceAllot记录  参数应该是对象
    @PostMapping("/update-Assign-Or-Handle")
    public TableDataVo allot(ServiceUserAllot serviceUserAllot){
        System.out.println("进入allotusert");
        System.out.println("setAllotTime-Before:"+serviceUserAllot);
        //更新分配时间
        if(serviceUserAllot.getAllotTime()==null)
        serviceUserAllot.setAllotTime(LocalDateTime.now());

        System.out.println("setAllotTime-After:"+serviceUserAllot);

         //更新处理时间
        System.out.println("setHandleTime-Before:"+serviceUserAllot);
        if(serviceUserAllot.getServiceHandle()!=null)
            serviceUserAllot.setHandleTime(LocalDateTime.now());

        System.out.println("setHandleTime-After:"+serviceUserAllot);

        //添加或者更新服务
        boolean flg = iServiceUserAllotService.saveOrUpdate(serviceUserAllot);
      if(flg){
            return TableDataVo.okMsg("服务更新成功！！");
        }
        return TableDataVo.failMsg("服务更新失败！！");

    }

    //by minghui

    @PostMapping("/feedbackEdit")
    public TableDataVo saveOrEdit(ServiceUserAllot serviceUserAllot){
       System.out.println("sssssssssssssssssssssssssssssssssssssss");
        System.out.println("serviceUserAllot-setNull="+serviceUserAllot);
        boolean flg = iServiceUserAllotService.updateById(serviceUserAllot);
        if(flg){
            return TableDataVo.okMsg("操作成功！！");
        }
        return TableDataVo.failMsg("操作失败！！");
    }


    @RequestMapping("/feedbackList")
    public TableDataVo list(Page page, @RequestParam(value = "search",required = false) String search){

        List<ServiceUserAllotVo> list = iServiceUserAllotService.servicePage(page, search);
        System.out.println("list***********************************************"+list);
        return TableDataVo.okData(page.getTotal(),list);
    }
}
