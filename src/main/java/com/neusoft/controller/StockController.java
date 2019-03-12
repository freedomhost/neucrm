package com.neusoft.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.neusoft.entity.Stock;
import com.neusoft.entity.vo.TableData;
import com.neusoft.service.IStockService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/stock")
public class StockController {

    @Autowired
    IStockService stockService;

    @RequestMapping("/list")
    public TableData list(Page page, Stock stock){
        List<Stock> stockList=stockService.stockPage(page, stock);
        return TableData.okData(page.getTotal(),stockList);
    }
}
