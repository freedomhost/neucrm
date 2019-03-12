package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.ServiceUserAllot;
import com.neusoft.entity.vo.ServiceUserAllotVo;
import com.neusoft.mapper.ServiceUserAllotMapper;
import com.neusoft.service.IServiceUserAllotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务用户分配表 服务用户关系表 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class ServiceUserAllotServiceImpl extends ServiceImpl<ServiceUserAllotMapper, ServiceUserAllot> implements IServiceUserAllotService {
    @Autowired
    private ServiceUserAllotMapper userAllotMapper;

    @Override
    public List<ServiceUserAllotVo> servicePage(Page page, String search) {
        return userAllotMapper.servicePage(page,search);
    }
}
