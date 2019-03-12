package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.Product;
import com.neusoft.entity.vo.TableData;
import com.neusoft.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

//    @RequestMapping("/list")
////    public TableData list(Page page, @RequestParam(value = "name",required = false) String name, @RequestParam(value = "type",required = false) String type, @RequestParam(value = "batch",required = false) String batch){
////        List<Product> productList = productService.productPage(page,name,type,batch);
////        return TableData.okData(page.getTotal(),productList);
////    }

    @RequestMapping("/list")
    public TableData list(Page page,Product product){
        System.out.println("~~~~~~~"+product);
        List<Product> productList = productService.productPage(page,product);
        return TableData.okData(page.getTotal(),productList);
    }

}
