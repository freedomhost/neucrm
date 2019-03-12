package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.entity.vo.AnalContributionVo;
import com.neusoft.mapper.AnalContributionMapper;
import com.neusoft.service.IAnalContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class AnalContributionServiceImpl extends ServiceImpl<AnalContributionMapper, AnalContributionVo> implements IAnalContributionService{

    @Autowired
    AnalContributionMapper analContributionMapper;

    @Override
    public List<AnalContributionVo> analContributionPage(Page page, String customerName, Integer year) {
        return analContributionMapper.analContributionPage(page,customerName,year);
    }
}
