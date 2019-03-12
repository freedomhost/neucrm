package com.neusoft.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableData {
    //layUI 数据表格的JSON
    private int code;
    private String msg;
    private long count;
    private Object data;//layui表格数据
    public static TableData okData(long count, Object data){
        return new TableData(0,"",count,data);
    }
    public static TableData okMsg(String msg){
        return new TableData(0,msg,0,null);
    }

    public static TableData failMsg(String msg){
        return new TableData(1,msg,0,null);
    }
}
