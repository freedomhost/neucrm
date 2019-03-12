package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerLoss;
import com.neusoft.entity.vo.CustomerLossVo;
import com.neusoft.mapper.CustomerLossMapper;
import com.neusoft.service.ICustomerLossService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 客户流失 客户流失 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class CustomerLossServiceImpl extends ServiceImpl<CustomerLossMapper, CustomerLoss> implements ICustomerLossService {

    @Autowired
    private CustomerLossMapper customerLossMapper;
    @Override
    public List<CustomerLossVo> pages(Page page, String customer,String manager,String status) {
        List<CustomerLossVo> list = customerLossMapper.pages(page,customer,manager,status);
        return list;
    }
}
