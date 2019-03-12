package com.neusoft.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.DataDict;
import com.neusoft.entity.vo.TableData;
import com.neusoft.entity.vo.TableDataVo;
import com.neusoft.service.IDataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/data-dict")
public class DataDictController {

    @Autowired
    IDataDictService dataDictService;

    //by 明辉
    @RequestMapping("/getDataDict")
    public DataDict getDataDictPage (DataDict dataDict){
        DataDict  dataDict1=dataDictService.getDataDict(dataDict);
        System.out.println("datadict1"+dataDict1);
        return dataDict1;
    }

    @RequestMapping("/list")
    public TableData list(Page page, DataDict dataDict){
        List<DataDict> dataDictList=dataDictService.dataDictPage(page, dataDict);
        return TableData.okData(page.getTotal(),dataDictList);
    }

    @ResponseBody
    @PostMapping("/save")
    public TableData save(DataDict dataDict){
        boolean save = dataDictService.save(dataDict);
        if (save){
            return TableData.okMsg("添加成功！");
        }
        else {
            return TableData.failMsg("添加失败！");
        }
    }

    @ResponseBody
    @PostMapping("/edit")
    public TableData edit(DataDict dataDict){
        System.out.println(""+dataDict);
        boolean save = dataDictService.updateById(dataDict);
        if (save){
            return TableData.okMsg("修改成功！");
        }
        else {
            return TableData.failMsg("修改失败！");
        }
    }

    @ResponseBody
    @PostMapping("/del/{id}")
    public TableData del(@PathVariable Integer id){
        boolean del = dataDictService.removeById(id);
        if (del){
            return TableData.okMsg("删除成功！");
        }
        else {
            return TableData.failMsg("删除失败！");
        }
    }

    @RequestMapping("/get/{type}")
    public TableDataVo get(@PathVariable String type){
        QueryWrapper<DataDict> con= new QueryWrapper<>();
        con.eq("type",type);
        List<DataDict> dataDictList=dataDictService.list(con);
        return TableDataVo.okData(dataDictList);
    }
}
