package com.neusoft.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shkstart
 * @create 2018/11/28 - 9:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)//无视ＮＵＬＬ
public class AnalConstituteVo {
    /**
     * 客户编号 客户编号
     */
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;
    /**
     *
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

    //数量
    private String countSum;
}
