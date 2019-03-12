package com.neusoft.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客户信息 客户信息
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
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号 客户编号
     */
    @TableId(value = "customer_id", type = IdType.AUTO)
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
    private LocalDateTime creationTime;


}
