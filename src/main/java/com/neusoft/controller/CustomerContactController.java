package com.neusoft.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.CustomerContact;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.ICustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p>
 * 客户联系人 客户联系人 前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/customer-contact")
public class CustomerContactController {
    @Autowired
    private ICustomerContactService contactService;

    @RequestMapping("/list/{cid}")
    public TableDataVo search(Page page, @PathVariable("cid") Integer cid,@RequestParam(name="search" ,required = false) String search){
        QueryWrapper<CustomerContact> cont = new QueryWrapper<>();
        cont.eq("customer_id", cid).and
                (Objects.nonNull(search),obj -> obj.like("id", search).or().
                        like("sex", search).or().
                        like("name", search).or().
                        like("phone", search).or().
                        like("job", search).or().
                        like("tel", search).or().
                        like("remark", search)
                    );
        IPage list = contactService.page(page, cont);
        return TableDataVo.okData(list.getTotal(),list.getRecords());
    }

    @RequestMapping("/save-edit")
    public TableDataVo saveOrUpdate(CustomerContact contact){
        boolean flg1 = Objects.nonNull(contact.getId());
        boolean flg2 = contactService.saveOrUpdate(contact);
        if(flg1){
            if (flg2)
                return TableDataVo.okMsg("保存成功！！");
            return TableDataVo.failMsg("保存失败！！");
        }else {
            if (flg2)
                return TableDataVo.okMsg("新建成功！！");
            return TableDataVo.failMsg("新建失败！！");
        }
    }
    @RequestMapping("/del/{id}")
    public TableDataVo saveOrUpdate(@PathVariable("id") Integer id){
        boolean flg = contactService.removeById(id);
        if (flg)
            return TableDataVo.okMsg("删除成功！！");
        return TableDataVo.failMsg("删除失败！！");

    }
}
