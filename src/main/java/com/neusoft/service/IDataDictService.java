package com.neusoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.DataDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IDataDictService extends IService<DataDict> {

    List<DataDict> dataDictPage(Page page,DataDict dataDict);
    DataDict getDataDict( DataDict dataDict);
}
