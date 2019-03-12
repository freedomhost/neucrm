package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.entity.SalesOpportunity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 销售机会 销售机会 Mapper 接口
 * </p>
 *
 */
public interface SalesOpportunityMapper extends BaseMapper<SalesOpportunity> {
    List<SalesOpportunity> userPage(IPage page, @Param("saop") SalesOpportunity saop);
}
