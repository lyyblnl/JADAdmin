package com.jad.JADAdmin.SysUserInfo.Model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jad.JADAdmin.Common.Enum.Sex;
import com.jad.JADAdmin.Common.Model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@ApiModel(value = "系统用户实体")
@Data
@TableName("sys_user_info")
public class SysUserInfo extends BaseEntity {
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "姓名")
    private String names;
    @ApiModelProperty(value = "性别")
    private Sex sex;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "出生日期")
    private Timestamp birthday;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "头像")
    private String headImg;
}
