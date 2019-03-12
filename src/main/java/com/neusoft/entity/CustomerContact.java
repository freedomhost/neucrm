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
 * 客户联系人 客户联系人
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
public class CustomerContact implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名 姓名
     */
    private String name;

    /**
     * 性别 性别
     */
    private String sex;

    /**
     * 职位 职位
     */
    private String job;

    /**
     * 办公电话 办公电话
     */
    private String phone;

    /**
     * 手机 手机
     */
    private String tel;

    /**
     * 备注 备注
     */
    private String remark;

    /**
     * 客户编号 客户编号
     */
    private Integer customerId;

    /**
     * 创建人 创建人
     */
    private String founder;

    /**
     * 创建人编号 创建人编号
     */
    private Integer foundId;

    /**
     * 操作时间 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime creationTime;
}
