package com.neusoft.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.OrderHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.vo.OrderAndCustomerVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 历史订单 历史订单 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface OrderHistoryMapper extends BaseMapper<OrderHistory> {

    List<OrderAndCustomerVo> orderAndLoss();

    List<OrderAndCustomerVo> newTime(Integer id);

    List<OrderAndCustomerVo> orderHis(Page page, @Param("cid") Integer cid);
}
