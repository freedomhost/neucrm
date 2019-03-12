package com.neusoft.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceUserAllotVo implements Serializable {
    private Integer id;

    /**
     * 服务类型 服务类型
     */
    private Integer serviceType;
    /**
     * 服务类型名称 服务类型名称
     */
    private String serviceTypeTitle;



    /**
     * 概要 概要
     */
    private String outline;

    /**
     * 客户名称 客户名称
     */
    private String customerName;

    /**
     * 客户编号 客户编号
     */
    private Integer customerId;

    /**
     * 状态(0:新创建,1：已分配,2：已处理)
     */
    private Integer status;


    /**
     * 状态名称(0:新创建,1：已分配,2：已处理)
     */
    private String statusTitle;


    /**
     * 服务请求 服务请求
     */
    private String serviceReq;

    /**
     * 创建人编号 创建人编号
     */
    private Integer creationId;

    /**
     * 创建人姓名 创建人姓名
     */
    private String creationName;

    /**
     * 创建时间 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime;

    /**
     * 服务编号 服务编号
     */
    private Integer serviceId;

    /**
     * 分配用户编号 分配用户编号
     */
    private Integer userId;

    /**
     * 分配用户名字 分配用户名字
     */
    private String userIdName;


    /**
     * 创建人编号 创建人编号
     */

    /**
     * 分配时间 分配时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime allotTime;

    /**
     * 服务处理 服务处理
     */
    private String serviceHandle;

    /**
     * 处理人 处理人
     */
    private String handleName;

    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime handleTime;

    /**
     * 处理结果 处理结果
     */
    private String handleResult;

    /**
     * 满意度 满意度
     */
    private Integer satisfaction;
}
