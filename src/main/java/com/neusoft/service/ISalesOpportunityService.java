package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.SalesOpportunity;

import java.util.List;

/**
 * <p>
 * 销售机会 销售机会 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface ISalesOpportunityService extends IService<SalesOpportunity> {
    List<SalesOpportunity> userPage(Page page, SalesOpportunity saop);
}
