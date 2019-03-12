package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.DataDict;
import com.neusoft.mapper.DataDictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2018/11/26 - 10:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatisplus.xml")
public class DataDictServiceImplTest {

    @Autowired
    DataDictMapper dataDictMapper;

    @Test
    public void dataDictPage() {
        Page page = new Page();
        DataDict dataDict = new DataDict();
        dataDict.setType("");
        dataDict.setTitle("2");
        dataDict.setValue(3);
        List<DataDict> dataDictList=dataDictMapper.dataDictPage(page, dataDict);
        System.out.println(""+dataDictList);
    }
}