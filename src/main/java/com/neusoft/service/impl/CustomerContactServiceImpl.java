package com.neusoft.service.impl;

import com.neusoft.entity.CustomerContact;
import com.neusoft.mapper.CustomerContactMapper;
import com.neusoft.service.ICustomerContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户联系人 客户联系人 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class CustomerContactServiceImpl extends ServiceImpl<CustomerContactMapper, CustomerContact> implements ICustomerContactService {

}
