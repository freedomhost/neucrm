package com.neusoft.entity.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDrawPlanVo {
    //id号：个数
    private Integer id;
    //客户开发id
    private Integer opportunityId;
    //计划时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planTime;
    //计划项
    private String planItem;
    /**
     * 执行效果 执行效果
     */
    private String result;

    /**
     * 创建人 创建人
     */
    private String founder;

    /**
     * 机会来源 机会来源
     */
    private String opportunitySource;
    /**
     * 客户名称 客户名称
     */
    private String name;
    /**
     * 成功几率 成功几率
     */
    private String successProbability;
    /**
     * 概要 概要
     */
    private String outline;
    /**
     * 联系人 联系人
     */
    private String contacts;
    /**
     * 联系电话 联系电话
     */
    private BigDecimal contactsTel;
    /**
     * 机会描述 机会描述
     */
    private String opportunityDesc;
    /**
     * 指派人编号 指派人编号
     */
    private BigDecimal assignId;
    /**
     * 指派人名称 指派人名称
     */
    private String assignName;
    /**
     * 指派时间 指派时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime assignTime;
    /**
     * 状态码(0:未指派，1：发开中，2：计划成功，3：计划失败)
     */
    private Integer status;
    /**
     * 创建人编号 创建人编号
     */
    private Integer foundId;
    /**
     * 创建人名称 创建人名称
     */
    private String foundName;
    /**
     * 创建时间 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime;

}

