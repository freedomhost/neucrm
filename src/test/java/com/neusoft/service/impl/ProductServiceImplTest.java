package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.Product;
import com.neusoft.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2018/11/26 - 9:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration("classpath:spring/spring-mybatisplus.xml")
public class ProductServiceImplTest {

    @Autowired
    ProductMapper productMapper;
    @Test
    public void productPage() {
        Page page = new Page();
        String name = "";
        String type = "";
        String batch = "";
        Product product= new Product();
        product.setType("i60");
        List<Product> productList=productMapper.productPage(page,product);
        System.out.println(""+productList);
        System.out.println(""+page.getTotal());
    }
}