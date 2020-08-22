package com.cxxwl96.ADAdmin.SystemUserInfo.Model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@ApiModel(value = "系统用户模型")
@Data
@TableName("sys_user_info")
public class SysUserInfo {

    @ApiModelProperty(value = "Id")
    @TableId
    private String id;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @TableField("CreateTime")
    private Timestamp CreateTime;
}
