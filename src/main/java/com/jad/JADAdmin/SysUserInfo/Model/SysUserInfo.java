package com.jad.JADAdmin.SysUserInfo.Model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jad.JADAdmin.Common.Model.EntityBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "系统用户实体")
@Data
@TableName("sys_user_info")
public class SysUserInfo extends EntityBase {
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "姓名")
    private String names;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "年龄")
    private String age;
    @ApiModelProperty(value = "出生日期")
    private String birthday;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "头像")
    private String headImg;
}
