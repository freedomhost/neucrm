package com.neusoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.ServiceManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.entity.vo.ServiceManagementFBVo;
import com.neusoft.entity.vo.ServiceManagementVo;


import java.util.List;

/**
 * <p>
 * 服务管理 服务管理 服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IServiceManagementService extends IService<ServiceManagement> {
    List<ServiceManagement> findAll(IPage page);
    List<ServiceManagement> findUnassignedService(IPage page, String search);
    List<ServiceManagementVo> findServiceFile(IPage page,String search);
    ServiceManagementVo findServiceFileById(Integer id);
    //min
    List<ServiceManagementFBVo> servicePage(Page page, String search);
}
