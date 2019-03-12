package com.neusoft.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.ServiceManagement;
import com.neusoft.entity.ServiceUserAllot;
import com.neusoft.entity.SystemUser;
import com.neusoft.entity.vo.ServiceManagementVo;
import com.neusoft.entity.vo.ServiceManagementFBVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.IServiceManagementService;
import com.neusoft.service.IServiceUserAllotService;
import com.neusoft.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务管理 服务管理 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/service-management")
public class ServiceManagementController {
    @Autowired
    private IServiceManagementService iServiceManagementService;
    @Autowired
    private IServiceUserAllotService iServiceUserAllotService;

    @Autowired
    private ISystemUserService iSystemUserService;
    private  String formatter="yyyy-MM-dd HH:mm";

    /*//获取创建服务表
    @RequestMapping("/list")
    public TableDataVo list(Page page, @RequestParam(value = "search",required = false) String search){

        System.out.println("现在时间    "+getTodayByFormat(formatter));

        List<ServiceManagement> list = iServiceManagementService.findAll(page);

        return TableDataVo.okData(page.getTotal(),list);
    }*/

    //获取创建服务表某一项
    @RequestMapping("/getService/{id}")
    public TableDataVo getServiceById(@PathVariable("id") Integer id){
        return TableDataVo.okData(iServiceManagementService.getById(id));
    }

    //创建服务表的创建
    @PostMapping("/save-edit")
    public TableDataVo saveOrEdit(ServiceManagement serviceManagement){

        boolean flg = iServiceManagementService.saveOrUpdate(serviceManagement);
        if(flg){
            return TableDataVo.okMsg("服务创建成功！！");
        }
        return TableDataVo.failMsg("服务创建失败！！");
    }
    //创建服务表的删除
    @PostMapping("/del/{id}")
    public TableDataVo del(@PathVariable("id") Integer id){
        boolean flg = iServiceManagementService.removeById(id);
        if(flg){
            return TableDataVo.okMsg("删除成功！！");
        }
        return TableDataVo.failMsg("删除失败！！");
    }



    //服务的分配

    //查询未分配服务项
    @RequestMapping("/findUnassignedService")
    public TableDataVo  findUnassignedService(Page page, @RequestParam(value = "search",required = false) String search){
        List<ServiceManagement> list = iServiceManagementService.findUnassignedService(page,search);
        return TableDataVo.okData(page.getTotal(),list);
    }

    //设置已经分配服务的状态为已分配
    @PostMapping("/setAllotStatus/{id}")
    public TableDataVo setAllotStatus(@PathVariable("id") Integer id){
        ServiceManagement serviceManagement= iServiceManagementService.getById(id);
        System.out.println("获取到的service"+serviceManagement.getCreationName()+serviceManagement.getServiceType());
        serviceManagement.setStatus(1);
        boolean flg=iServiceManagementService.saveOrUpdate(serviceManagement);
        if(flg){
            return TableDataVo.okMsg("服务分配成功！！");
        }
        return TableDataVo.failMsg("服务分配失败！！");
    }

    //服务处理/service-management/findServiceFiles

    @RequestMapping("/findServiceFiles")
    public TableDataVo  findServiceFile(Page page, @RequestParam(value = "search",required = false) String search){

        List<ServiceManagementVo> list = iServiceManagementService.findServiceFile(page,search);
        System.out.println("list");
        System.out.println(list);
        return TableDataVo.okData(page.getTotal(),list);
    }


    //服务处理查询/service-management/findServiceFileById

    @RequestMapping("/findServiceFileById/{id}")
    public ServiceManagementVo  findServiceFileById(@PathVariable("id") Integer id){
        ServiceManagementVo serviceManagementVo = iServiceManagementService.findServiceFileById(id);

        return serviceManagementVo;
    }

    @PostMapping("/setStatus/{id}")
    public TableDataVo setStatus(@PathVariable("id") Integer id){
        ServiceManagement serviceManagement= iServiceManagementService.getById(id);
//        ServiceUserAllot serviceUserAllot=iServiceUserAllotService.getById((id));
//        if (serviceUserAllot.getSatisfaction()>=3){
//
//        }

        serviceManagement.setStatus(serviceManagement.getStatus()+1);
        System.out.println("setStatus="+serviceManagement);
        boolean flg=iServiceManagementService.saveOrUpdate(serviceManagement);
        if(flg){
            return TableDataVo.okMsg("增长状态成功！！");
        }
        return TableDataVo.failMsg("增长状态失败！！");
    }
    //设置已经分配服务的状态为已处理
    @PostMapping("/setHandleStatus/{id}")
    public TableDataVo setHandleStatus(@PathVariable("id") Integer id){
        ServiceManagement serviceManagement= iServiceManagementService.getById(id);

        serviceManagement.setStatus(2);
        System.out.println("setStatus="+serviceManagement);
        boolean flg=iServiceManagementService.saveOrUpdate(serviceManagement);
        if(flg){
            return TableDataVo.okMsg("服务处理成功！！");
        }
        return TableDataVo.failMsg("服务处理失败！！");
    }
           //BY  MINGHUI    ---fankui
           @RequestMapping("/feedbackEdit")
           public TableDataVo saveOrEditFB(ServiceManagement serviceManagement){
               System.out.println("qsssssssssssssssssssssssssssssssssssssssq");
               System.out.println(serviceManagement.getStatus());
               boolean flg = iServiceManagementService.updateById(serviceManagement);
               if(flg){
                   return TableDataVo.okMsg("操作成功！！");
               }
               return TableDataVo.failMsg("操作失败！！");
           }

    @RequestMapping("/feedbackList")
    public TableDataVo list(Page page, @RequestParam(value = "search",required = false) String search){

        List<ServiceManagementFBVo> list = iServiceManagementService.servicePage(page, search);
        System.out.println("list*************************************************************************"+list);
        return TableDataVo.okData(page.getTotal(),list);
    }


    public static String getTodayByFormat(String timeFormat){

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(timeFormat));
    }
}
