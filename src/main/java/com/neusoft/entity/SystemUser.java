package com.neusoft.entity;

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
 * 系统用户 系统用户
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
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称 用户名称
     */
    private String name;

    /**
     * 登录名 登录名
     */
    private String logName;

    /**
     * 登录密码 登录密码
     */
    private String logPwd;

    /**
     * 角色编号 角色编号
     */
    private Integer roleId;


}
