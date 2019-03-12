package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.entity.ServiceManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.vo.ServiceManagementFBVo;
import com.neusoft.entity.vo.ServiceManagementVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务管理 服务管理 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface ServiceManagementMapper extends BaseMapper<ServiceManagement> {
    List<ServiceManagement> findAll(IPage page);
    List<ServiceManagement> findUnassignedService(IPage page,@Param("search") String search);
    List<ServiceManagementVo> findServiceFile(IPage page,@Param("search") String search);
    ServiceManagementVo findServiceFileById(Integer id);
    //min
    List<ServiceManagementFBVo> servicePage(IPage page, @Param("search") String search);
}
