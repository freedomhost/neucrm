package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.AnalLossVo;

import java.util.List;

/**
 * @author CDHong
 * @since 2018-11-22
 */
public interface IAnalLossService extends IService<AnalLossVo> {
    List<AnalLossVo> analLossPage(Page page,String customerName,String customerMgr);
}
