package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalContributionVo;
import com.neusoft.entity.vo.AnalLossVo;
import com.neusoft.entity.vo.TableData;
import com.neusoft.service.IAnalContributionService;
import com.neusoft.service.IAnalLossService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/analyseContribution")
public class AnalContributionController {

    @Autowired
    IAnalContributionService analContributionService;

    @RequestMapping("/list")
    public TableData list(Page page,String customerName,Integer year){
        List<AnalContributionVo> analContributionVoList=analContributionService.analContributionPage(page, customerName, year);
        System.out.println("!!!!!" + ""+analContributionVoList);
        return TableData.okData(page.getTotal(),analContributionVoList);
    }


}
