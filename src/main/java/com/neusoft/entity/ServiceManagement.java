package com.neusoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 服务管理 服务管理
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)//无视ＮＵＬＬ
public class ServiceManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务类型 服务类型
     */
    private Integer serviceType;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime;


}
