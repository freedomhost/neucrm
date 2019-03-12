package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.entity.vo.AnalServiceVo;
import com.neusoft.mapper.AnalServiceMapper;
import com.neusoft.service.IAnalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 交往记录 交往记录 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class AnalServiceServiceImpl extends ServiceImpl<AnalServiceMapper, AnalServiceVo> implements IAnalServiceService {

    @Autowired
    AnalServiceMapper analServiceMapper;

    @Override
    public List<AnalServiceVo> analServicePage(Page page, Integer year) {
        return analServiceMapper.analServicePage(page,year);
    }
}
