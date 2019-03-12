package com.neusoft.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.Stock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface StockMapper extends BaseMapper<Stock> {
    List<Stock> stockPage(Page page,@Param("stock") Stock stock);
}
