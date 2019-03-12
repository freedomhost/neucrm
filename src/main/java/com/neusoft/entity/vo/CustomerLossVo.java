package com.neusoft.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//无视ＮＵＬＬ
public class CustomerLossVo implements Serializable{

    /**
     * 编号 流失编号
     */
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
