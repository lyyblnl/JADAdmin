package com.jad.JADAdmin.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ApiModel(value = "请求结果模型")
@Component
@ToString
public class JsonResult {
    @ApiModelProperty(value = "返回代码")
    public String code = "";

    @ApiModelProperty(value = "请求状态")
    public boolean success = false;

    @ApiModelProperty(value = "返回消息")
    public String msg = "请求失败";

    @ApiModelProperty(value = "返回数据")
    public Object data;

    @ApiModelProperty(value = "重定向url")
    public String url;

    @ApiModelProperty(value = "查询对象")
    public SearchLayer search;
}
