package com.neusoft.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 系统用户 系统用户
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//无视ＮＵＬＬ
public class SystemUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String logName;

    private String logPwd;

    private Integer roleId;

    private String roleName;

    private String NewLogPwd;

}
