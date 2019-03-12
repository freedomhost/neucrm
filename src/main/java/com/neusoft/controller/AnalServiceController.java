package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalServiceVo;
import com.neusoft.entity.vo.TableData;
import com.neusoft.service.IAnalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 交往记录 交往记录 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/analService")
public class AnalServiceController {

    @Autowired
    IAnalServiceService analServiceService;

    @RequestMapping("/list")
    public TableData list(Page page,Integer year){
        List<AnalServiceVo> analServiceVoList=analServiceService.analServicePage(page, year);
        System.out.println("!!!!!!!!"+analServiceVoList);
        return TableData.okData(page.getTotal(),analServiceVoList);
    }
}
