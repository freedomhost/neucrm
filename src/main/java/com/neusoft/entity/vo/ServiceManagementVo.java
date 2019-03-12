package com.neusoft.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceManagementVo {
    private Integer id;//allot表编号
    private Integer serviceId;  //服务编号
    private  Integer  serviceType;//届时有了数据字典就改为Integer  服务类型

    /**
     * 服务类型名称 服务类型名称
     */
    private String serviceTypeTitle;

    private String outline;//概要
    private  String customerName;//客户
    private String serviceReq;//服务请求

    private Integer status;//状态
    /**
     * 状态名称(0:新创建,1：已分配,2：已处理)
     */
    private String statusTitle;

    private String creationName;//创建人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime; //创建时间

    private  Integer UserId;//分配给

    /**
     * 分配用户名字 分配用户名字
     */
    private String userIdName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime allotTime;//分配时间

    private String serviceHanle;//服务处理
    private String handleName;//处理人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime handleTime;  //处理时间

    private String handleResult;//处理结果
    private Integer satisfaction; //满意度


}
