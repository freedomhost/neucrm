package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.entity.SalesOpportunity;
import com.neusoft.mapper.SalesOpportunityMapper;
import com.neusoft.service.ISalesOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 销售机会 销售机会 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class SalesOpportunityServiceImpl extends ServiceImpl<SalesOpportunityMapper, SalesOpportunity> implements ISalesOpportunityService {
    @Autowired
    private SalesOpportunityMapper sopMapper;

    @Override
    public List<SalesOpportunity> userPage(Page page, SalesOpportunity saop) {
        return sopMapper.userPage(page,saop);
    }
}
