package com.neusoft.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.entity.Role;
import com.neusoft.entity.Stock;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.IRoleService;
import com.neusoft.service.IStockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatisplus.xml")
public class ImplTest {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IStockService stockService;

    @Test
    public void findById(){
        System.out.println( roleService.getById("4"));
    }

    @Test
    public void findAll(){
        roleService.list().forEach(System.out::println);
        stockService.list().forEach(System.out::println);
    }
    @Test
    public void save(){
        Role role = new Role();
        role.setName("测试");
        role.setStatus(0);
        role.setCode(4);
        System.out.println( roleService.save(role));
        Stock stock = new Stock();
        stock.setNumber(111);
        stock.setRemark("12313");
        System.out.println( stockService.save(stock));

    }
    @Test
    public void edit(){
        Role role2 = new Role();
        role2.setId(5);
        role2.setName("测试2");
        System.out.println( roleService.updateById(role2));
    }
    @Test
    public void del(){
        System.out.println( roleService.removeById("5"));
    }

    @Test
    public void page(){//分页
        Page page = new Page(1,3);
        IPage list = roleService.page(page);
        List records = list.getRecords();//数据
        long total = list.getTotal();//总条数
        TableDataVo pageJSON = TableDataVo.okData(total,records);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(pageJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}