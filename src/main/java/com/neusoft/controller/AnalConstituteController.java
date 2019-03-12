package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalConstituteVo;
import com.neusoft.entity.vo.TableData;
import com.neusoft.service.IAnalConstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/analyseConstitute")
public class AnalConstituteController {

    @Autowired
    IAnalConstituteService analConstituteService;

    @RequestMapping("/list")
    public TableData list(Page page,String search){
        List<AnalConstituteVo> analConstituteVoList =analConstituteService.analConstitutePage(page,search);
        System.out.println("1111111"+page.getTotal());
        return TableData.okData(page.getTotal(),analConstituteVoList);
    }

    @RequestMapping("/searchAnaly/{search}")
    public TableData searchAnaly(Page page, @PathVariable(value = "search",required = false) String search){
        List<AnalConstituteVo> analConstituteVoList = analConstituteService.analConstitutePage(page,search);
        return TableData.okData(page.getTotal(),analConstituteVoList);
    }
}
