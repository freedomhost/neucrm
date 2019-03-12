package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalConstituteVo;
import com.neusoft.entity.vo.AnalLossVo;
import com.neusoft.entity.vo.TableData;
import com.neusoft.service.IAnalConstituteService;
import com.neusoft.service.IAnalLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/analyseLoss")
public class AnalLossController {

    @Autowired
    IAnalLossService analLossService;

    @RequestMapping("/list")
    public TableData list(Page page,String customerName,String customerMgr){
        List<AnalLossVo> analLossVoList=analLossService.analLossPage(page, customerName, customerMgr);
        System.out.println("1111111"+page.getTotal());
        return TableData.okData(page.getTotal(),analLossVoList);
    }

    @RequestMapping("/searchAnaly/{search}")
    public TableData searchAnaly(Page page,String customerName,String customerMgr){
        List<AnalLossVo> analLossVoList=analLossService.analLossPage(page, customerName, customerMgr);
        return TableData.okData(page.getTotal(),analLossVoList);
    }
}
