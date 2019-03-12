package com.neusoft.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.ServiceManagement;
import com.neusoft.entity.vo.ServiceManagementFBVo;
import com.neusoft.entity.vo.ServiceManagementVo;
import com.neusoft.mapper.ServiceManagementMapper;
import com.neusoft.service.IServiceManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务管理 服务管理 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class ServiceManagementServiceImpl extends ServiceImpl<ServiceManagementMapper, ServiceManagement> implements IServiceManagementService {
    @Autowired
    private  ServiceManagementMapper serviceManagementMapper;
    public List<ServiceManagement> findAll(IPage page)
    {
        List<ServiceManagement> list=serviceManagementMapper.findAll(page);
        return  list;
    }
    public List<ServiceManagement> findUnassignedService(IPage page,String search){
        List<ServiceManagement> list=serviceManagementMapper.findUnassignedService(page,search);
        return  list;
    }
    //查询成最终会归档的全部内容表
    public List<ServiceManagementVo> findServiceFile(IPage page,String search){
        List<ServiceManagementVo> list=serviceManagementMapper.findServiceFile(page, search);
        return  list;
    }
    //findById
    public ServiceManagementVo findServiceFileById(Integer id){

        return serviceManagementMapper.findServiceFileById(id);
    }
    //min
    @Override
    public List<ServiceManagementFBVo> servicePage(Page page, String search)  {
        return serviceManagementMapper.servicePage(page,search);
    }

}
