package com.neusoft.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerInfo;
import com.neusoft.entity.vo.CustomerInfoVo;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.mapper.CustomerInfoMapper;
import com.neusoft.service.ICustomerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 客户信息 客户信息 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements ICustomerInfoService {

    @Autowired
    private CustomerInfoMapper mapper;
    @Override
    public List<CustomerInfoVo> pagew(Page page, String search) {
        List<CustomerInfoVo> list = mapper.pagew(page, search);
        return list;
    }
}
