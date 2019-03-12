package com.neusoft.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.entity.Menu;
import com.neusoft.entity.SystemUser;
import com.neusoft.entity.vo.RoleMenuVo;
import com.neusoft.entity.vo.SystemUserVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.ISystemUserService;
import com.neusoft.service.impl.SystemUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统用户 系统用户 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/system-user")
public class SystemUserController {
    @Autowired
    private ISystemUserService systemUserService;

    @RequestMapping("/customer-mgr")
    public List<SystemUserVo> getCustomerMgr(){//获取到所有客户经理
        List<SystemUserVo> list = systemUserService.getCustomerMgr();
        return list;
    }


    @RequestMapping("/login")
    public TableDataVo login(String logName,String logPwd,HttpSession session){
        QueryWrapper<SystemUser> con = new QueryWrapper<>();
        con.eq("log_name",logName).eq("log_pwd",logPwd);
        List<SystemUser> list = systemUserService.list(con);
        if (list.size()>0){
            session.setAttribute("login",list.get(0).getId());
            return TableDataVo.okMsg("登陆成功!!");
        }
        return TableDataVo.failMsg("账号或密码错误!!");
    }

    @RequestMapping("/logout")
    public TableDataVo logout(HttpSession session){
        session.invalidate();
        return TableDataVo.okMsg("退出成功!!");
    }

    @RequestMapping("/login-info")
    public TableDataVo loginInfo(HttpSession session){
        if(Objects.nonNull(session.getAttribute("login"))){
            Integer id = Integer.parseInt(session.getAttribute("login").toString());
            SystemUserVo user = systemUserService.getUserVoById(id);
            return TableDataVo.okData(user);
        }
        return TableDataVo.failMsg("获取失败!");
    }

    @PostMapping("/save")
    public TableDataVo save(SystemUser user){
        System.out.println("!!!!!!!"+user);
        boolean save = systemUserService.updateById(user);
        if (save){
            return TableDataVo.okMsg("修改成功！");
        }else {
            return TableDataVo.failMsg("无法修改");
        }

    }

    @PostMapping("/updatePwd")
    public TableDataVo updatePwd(SystemUserVo userVo){
        System.out.println("!!!!!!!"+userVo);
//        boolean save = systemUserService.updateById(user);
/*        if (save){
            return TableDataVo.okMsg("修改成功！");
        }else {
            return TableDataVo.failMsg("无法修改");
        }*/
        Integer id = userVo.getId();

        SystemUserVo user = systemUserService.getUserVoById(id);
        String logPwd = user.getLogPwd();

        System.out.println("logpwd@@@@"+logPwd);
        if (!logPwd.equals(userVo.getLogPwd()) ){
            return TableDataVo.failMsg("当前密码输入错误！");
        }else {
            SystemUser systemUser = new SystemUser();
            systemUser.setId(id);
            systemUser.setLogPwd(userVo.getNewLogPwd());
            System.out.println("sys~~~~"+systemUser);
            systemUserService.updateById(systemUser);
            return TableDataVo.okMsg("密码修改成功！请重新登录！");
        }

    }

    @RequestMapping(value = "/getMenus", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public List<RoleMenuVo> getMenus(HttpServletRequest req, HttpServletResponse resp) {
        Integer id =(Integer) req.getSession().getAttribute("login");
        SystemUserVo user=systemUserService.getUserVoById(id);
        Integer roleId=user.getRoleId();
//        TbAdmin admin = (TbAdmin)SecurityUtils.getSubject().getPrincipal();
        List<RoleMenuVo> menus = null;
        if (id != null) {
            // 得到用户菜单
            menus = systemUserService.selMenus(user);
        }
        System.out.println("menus~~~"+menus);
        return menus;
    }






}