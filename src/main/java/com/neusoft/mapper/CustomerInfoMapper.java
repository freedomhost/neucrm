package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.entity.vo.CustomerInfoVo;
import com.neusoft.entity.vo.TableDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 客户信息 客户信息 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {
    List<CustomerInfoVo> pagew(Page page, @Param("search") String search);
}
