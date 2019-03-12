package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.entity.CustomerContact;
import com.neusoft.entity.DrawPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.SalesOpportunity;
import com.neusoft.entity.SystemUser;
import com.neusoft.entity.vo.SaleDrawPlanVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 制定计划 制定计划 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface DrawPlanMapper extends BaseMapper<DrawPlan> {
    List<SaleDrawPlanVo> sdpvPage(IPage page, @Param("search") String search);
    List<DrawPlan> dpPage(IPage page, @Param("search") Integer search);
    SalesOpportunity so(Integer id);
    CustomerContact cc(String name);
    SystemUser su(String name);
}
