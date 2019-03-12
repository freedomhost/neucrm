package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.DataDict;
import com.neusoft.mapper.DataDictMapper;
import com.neusoft.service.IDataDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class DataDictServiceImpl extends ServiceImpl<DataDictMapper, DataDict> implements IDataDictService {

    @Autowired
    DataDictMapper dataDictMapper;

    @Override
    public List<DataDict> dataDictPage(Page page, DataDict dataDict) {
        return dataDictMapper.dataDictPage(page,dataDict);
    }
   public DataDict getDataDict( DataDict dataDict){
        return dataDictMapper.getDataDict(dataDict);
   }

}
