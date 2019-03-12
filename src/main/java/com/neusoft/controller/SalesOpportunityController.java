package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.SalesOpportunity;
import com.neusoft.entity.SystemUser;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.ISalesOpportunityService;
import com.neusoft.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 销售机会 销售机会 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/sopt")
public class SalesOpportunityController {
    @Autowired
    private ISalesOpportunityService isopService;

    @Autowired
    private ISystemUserService iuserService;

    @RequestMapping("/list")
    public TableDataVo list(Page page, SalesOpportunity saop){
        List<SalesOpportunity> list = isopService.userPage(page, saop);
        return TableDataVo.okData(page.getTotal(),list);
    }

    @RequestMapping("/del/{id}")
    public TableDataVo del(@PathVariable("id") Integer id){
        boolean flg = isopService.removeById(id);
        if(flg){
            return TableDataVo.okMsg("删除成功！！");
        }
        return TableDataVo.failMsg("删除失败！！");
    }
    @RequestMapping("/save-edit")
    public TableDataVo saveOrEdit(SalesOpportunity sop){
        System.out.println(""+sop);
        if(sop.getAssignName() != null && !sop.getAssignName().equals("")){
            sop.setStatus(1);
        }
        if(sop.getAssignName() == null || sop.getAssignName().equals("")){
            sop.setStatus(0);
        }
        boolean flg = isopService.saveOrUpdate(sop);
        if(flg){
            return TableDataVo.okMsg("操作成功！！");
        }
        return TableDataVo.failMsg("操作失败！！");
    }

    @RequestMapping("/role")
    public List<SystemUser> getAllRoles(){
        Stream<SystemUser> stream = iuserService.list().stream().filter(x -> x.getRoleId() == 3);
        List<SystemUser> list = stream.collect(Collectors.toList());
        return list;
    }
}
