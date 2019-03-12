package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalLossVo;
import com.neusoft.entity.vo.AnalServiceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 交往记录 交往记录 Mapper 接口
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface AnalLossMapper extends BaseMapper<AnalLossVo> {

    List<AnalLossVo> analLossPage(Page page, @Param("customerName") String customerName,@Param("customerMgr") String customerMgr);

}
