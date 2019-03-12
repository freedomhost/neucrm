package com.neusoft.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表 菜单表
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
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称 菜单名称
     */
    private String meunName;

    /**
     * 菜单图标 菜单图表
     */
    private String menuIcon;

    /**
     * 上级编号 上级编号
     */
    private Integer parentId;

    /**
     * 级别 级别
     */
    private BigDecimal level;

    /**
     * 是否展开 是否展开
     */
    private BigDecimal isSpread;


}
