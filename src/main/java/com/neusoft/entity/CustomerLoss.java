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

/**
 * <p>
 * 客户流失 客户流失
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
public class CustomerLoss implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号 流失编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户名称 客户名称
     */
    private String customerName;

    /**
     * 客户经理 客户经理
     */
    private String customerMgr;

    /**
     * 客户编号 客户编号
     */
    private Integer customerId;

    /**
     * 上次下单时间 上次下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastOrderTime;

    /**
     * 暂缓措施 暂缓措施
     */
    private String pauseWay;

    /**
     * 追加暂缓措施 暂缓措施
     */
    private String addPauseWay;

    /**
     * 确认流失时间 确认流失时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lossTime;

    /**
     * 流失原因 流失原因
     */
    private String lossReason;

    /**
     * 状态（0：暂缓流失，1：确认流失）
     */
    private Integer status;


}
