package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalContributionVo;
import com.neusoft.mapper.AnalContributionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2018/11/28 - 21:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatisplus.xml")
public class AnalContributionServiceImplTest {

    @Autowired
    AnalContributionMapper analContributionMapper;

    @Test
    public void analContributionPage() {
        Page page = new Page();
        List<AnalContributionVo> analContributionVoList = analContributionMapper.analContributionPage(page, "分", null);
        System.out.println("!!!!!"+analContributionVoList);
    }
}