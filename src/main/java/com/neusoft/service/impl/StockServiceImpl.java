package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.Stock;
import com.neusoft.mapper.StockMapper;
import com.neusoft.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class  StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

    @Autowired
    StockMapper stockMapper;

    @Override
    public List<Stock> stockPage(Page page, Stock stock) {
        return stockMapper.stockPage(page,stock);
    }
}
