package com.neusoft.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.entity.*;
import com.neusoft.entity.vo.SaleDrawPlanVo;
import com.neusoft.mapper.DrawPlanMapper;
import com.neusoft.service.IDrawPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 制定计划 制定计划 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class DrawPlanServiceImpl extends ServiceImpl<DrawPlanMapper, DrawPlan> implements IDrawPlanService {
    @Autowired
    private DrawPlanMapper userMapper;
    @Override
    public List<SaleDrawPlanVo> sdpvPage(IPage page, String search) {
        return userMapper.sdpvPage(page,search);
    }
    @Override
    public List<DrawPlan> dpPage(IPage page, Integer search) {
        return userMapper.dpPage(page,search);
    }

    @Override
    public SalesOpportunity so(Integer id) {
        return userMapper.so(id);
    }

    @Override
    public CustomerContact cc(String name) {
        return userMapper.cc(name);
    }

    @Override
    public SystemUser su(String name) {
        return userMapper.su(name);
    }
}
