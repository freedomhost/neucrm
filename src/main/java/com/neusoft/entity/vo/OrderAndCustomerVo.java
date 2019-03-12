package com.neusoft.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//无视ＮＵＬＬ
public class OrderAndCustomerVo implements Serializable {
    private Integer customerId;

    /**
     * 客户名称 客户名称
     */
    private String customerName;

    /**
     * 地区 地区
     */
    private String city;

    /**
     * 客户经理 客户经理
     */
    private String customerMgr;

    /**
     * 客户经理编号 客户经理编号
     */
    private BigDecimal customerMgrId;

    /**
     * 客户等级 客户等级
     */
    private String customerGrade;

    /**
     * 客户满意度 客户满意度
     */
    private String customerSatisfaction;

    /**
     * 客户信用度 客户信用度
     */
    private String customerCredit;

    /**
     * 地址 地址
     */
    private String address;

    /**
     * 邮政编码 邮政编码
     */
    private BigDecimal postalCode;

    /**
     * 电话 电话
     */
    private String phone;

    /**
     * 传真 传真
     */
    private String fax;

    /**
     * 网址 网址
     */
    private String ulr;

    /**
     * 营业执照注册号 营业执照注册号
     */
    private String businessLicense;

    /**
     * 法人 法人
     */
    private String juridicalPerson;

    /**
     * 注册资金 注册资金
     */
    private Double registeredCapital;

    /**
     * 年营业额 年营业额
     */
    private Double annualSales;

    /**
     * 开户银行 开户银行
     */
    private String depositBank;

    /**
     * 银行账号 银行账号
     */
    private String bankAccount;

    /**
     * 地税登记号 地税登记号
     */
    private String landTaxCode;

    /**
     * 国税登记号 国税登记号
     */
    private String centralTax;

    /**
     * 创建人 创建人
     */
    private String founder;

    /**
     * 创建人编号 创建人编号
     */
    private Integer foundId;

    /**
     * 创建时间 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime;
    private Integer id;

    /**
     * 订单时间 订单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;

    /**
     * 送货地址 送货地址
     */
    private String deliverGoods;

    /**
     * 状态(0:未回款,1：已汇款)
     */
    private Integer status;
    /*
     *总金额
     */
    private Double totalAmount;


}
