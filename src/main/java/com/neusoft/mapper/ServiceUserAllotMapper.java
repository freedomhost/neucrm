package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.entity.ServiceUserAllot;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.vo.ServiceUserAllotVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务用户分配表 服务用户关系表 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface ServiceUserAllotMapper extends BaseMapper<ServiceUserAllot> {
    List<ServiceUserAllotVo> servicePage(IPage page, @Param("search") String search);
}
