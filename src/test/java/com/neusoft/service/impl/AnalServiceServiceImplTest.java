package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalServiceVo;
import com.neusoft.mapper.AnalServiceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2018/11/28 - 9:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatisplus.xml")
public class AnalServiceServiceImplTest {

    @Autowired
    AnalServiceMapper analServiceMapper;

    @Test
    public void analServicePage() {
        Page page = new Page();
        List<AnalServiceVo> analServiceVos=analServiceMapper.analServicePage(page,null);
        System.out.println(""+analServiceVos);
    }
}