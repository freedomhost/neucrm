package com.neusoft.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.neusoft.entity.ContactRecord;
import com.neusoft.entity.CustomerContact;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.IContactRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 交往记录 交往记录 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/contact-record")
public class ContactRecordController {
    @Autowired
    private IContactRecordService recordService;

    @RequestMapping("/list/{cid}")
    public TableDataVo search(Page page, @PathVariable("cid") Integer cid, @RequestParam(name="search" ,required = false) String search){
        QueryWrapper<ContactRecord> cont = new QueryWrapper<>();
        cont.eq("customer_id", cid).and
                (Objects.nonNull(search), obj -> obj.like("id", search).or().
                        like("place", search).or().
                        like("outline", search).or().
                        like("detailed_info", search).or().
                        like("remarks", search).or()
                );
        IPage list = recordService.page(page, cont);
        return TableDataVo.okData(list.getTotal(),list.getRecords());
    }

    @RequestMapping("/save-edit")
    public TableDataVo saveOrUpdate(ContactRecord record){
        boolean flg1 = Objects.nonNull(record.getId());
        boolean flg2 = recordService.saveOrUpdate(record);
        if(flg1){
            if (flg2) {
                return TableDataVo.okMsg("保存成功！！");
            }
            return TableDataVo.failMsg("保存失败！！");
        }else {
            if (flg2) {
                return TableDataVo.okMsg("新建成功！！");
            }
            return TableDataVo.failMsg("新建失败！！");
        }

    }
    @RequestMapping("/del/{id}")
    public TableDataVo saveOrUpdate(@PathVariable("id") Integer id){
        boolean flg = recordService.removeById(id);
        if (flg)
            return TableDataVo.okMsg("删除成功！！");
        return TableDataVo.failMsg("删除失败！！");
    }
}
