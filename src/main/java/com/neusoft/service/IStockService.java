package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.Stock;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IStockService extends IService<Stock> {
    List<Stock> stockPage(Page page, @Param("stock") Stock stock);
}
