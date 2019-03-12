package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.AnalServiceVo;

import java.util.List;

/**
 * <p>
 * 交往记录 交往记录 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IAnalServiceService extends IService<AnalServiceVo> {
    List<AnalServiceVo> analServicePage(Page page, Integer year);
}
