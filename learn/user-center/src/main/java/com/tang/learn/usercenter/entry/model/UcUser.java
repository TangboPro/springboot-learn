package com.tang.learn.usercenter.entry.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @Classname UcUser
 * @Description TODO
 * @Date 2019/11/23 15:24
 * @author tang
 */
@ApiModel(value="com.tang.learn.usercenter.common.model.UcUser")
@Data
@TableName(value = "t_uc_user")
public class UcUser {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="null")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="手机号码")
    private String phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    @TableField(value = "status")
    @ApiModelProperty(value="帐号启用状态:0->禁用；1->启用")
    private Integer status;

    /**
     * 注册时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="注册时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_PHONE = "phone";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}