package com.jad.JADAdmin.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.stereotype.Component;

@ApiModel(value = "请求结果模型")
@Component
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

    public JsonResult() {
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

    public JsonResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public JsonResult(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult setCode(String code) {
        this.code = code;
        return this;
    }

    public JsonResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public JsonResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    public JsonResult setData(Object data) {
        this.data = data;
        return this;
    }

    public JsonResult setUrl(String url) {
        this.url = url;
        return this;
    }

    public JsonResult setSearch(SearchLayer search) {
        this.search = search;
        return this;
    }
}
