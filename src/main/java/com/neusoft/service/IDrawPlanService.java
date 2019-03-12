package com.neusoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.entity.CustomerContact;
import com.neusoft.entity.DrawPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.SalesOpportunity;
import com.neusoft.entity.SystemUser;
import com.neusoft.entity.vo.SaleDrawPlanVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 制定计划 制定计划 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IDrawPlanService extends IService<DrawPlan> {
    List<SaleDrawPlanVo> sdpvPage(IPage page, @Param("search") String search);
    List<DrawPlan> dpPage(IPage page, @Param("search") Integer search);
    SalesOpportunity so(Integer id);
    CustomerContact cc(String name);
    SystemUser su(String name);
}
