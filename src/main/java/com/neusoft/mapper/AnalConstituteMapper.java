package com.neusoft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.ContactRecord;
import com.neusoft.entity.vo.AnalConstituteVo;
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
public interface AnalConstituteMapper extends BaseMapper<AnalConstituteVo> {
    List<AnalConstituteVo> analConstitutePage(Page page, @Param("searchAnaly") String searchAnaly);

}
