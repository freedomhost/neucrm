package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.vo.AnalConstituteVo;
import com.neusoft.entity.vo.AnalContributionVo;
import com.neusoft.entity.vo.AnalLossVo;
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
public interface AnalContributionMapper extends BaseMapper<AnalContributionVo> {

    List<AnalContributionVo> analContributionPage(Page page, @Param("customerName") String customerName, @Param("year") Integer year);

}
