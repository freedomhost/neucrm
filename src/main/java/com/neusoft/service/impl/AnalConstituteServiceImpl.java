package com.neusoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.entity.ContactRecord;
import com.neusoft.entity.vo.AnalConstituteVo;
import com.neusoft.mapper.AnalConstituteMapper;
import com.neusoft.mapper.AnalServiceMapper;
import com.neusoft.mapper.ContactRecordMapper;
import com.neusoft.service.IAnalConstituteService;
import com.neusoft.service.IContactRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 交往记录 交往记录 服务实现类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Service
public class AnalConstituteServiceImpl extends ServiceImpl<AnalConstituteMapper, AnalConstituteVo> implements IAnalConstituteService {

    @Autowired
    AnalConstituteMapper analConstituteMapper;

    @Override
    public List<AnalConstituteVo> analConstitutePage(Page page, String searchAnaly) {
        return analConstituteMapper.analConstitutePage(page,searchAnaly);
    }
}
