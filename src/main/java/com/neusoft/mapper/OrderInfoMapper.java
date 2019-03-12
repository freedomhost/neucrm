package com.neusoft.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    List<OrderInfo> list(Page page, @Param("cid") Integer cid);
}
