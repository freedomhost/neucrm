package com.neusoft.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerLoss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.vo.CustomerLossVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 客户流失 客户流失 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface CustomerLossMapper extends BaseMapper<CustomerLoss> {
    List<CustomerLossVo> pages(Page page, @Param("customer") String customer,@Param("manager")String manger,@Param("status") String status);
}
