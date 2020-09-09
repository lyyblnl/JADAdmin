package com.jad.JADAdmin.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "分页查询模型")
@Data
public class SearchLayer {
    @ApiModelProperty(value = "当前页码")
    public int current = 1;

    @ApiModelProperty(value = "长度")
    public int size = 20;

    @ApiModelProperty(value = "当前页数量")
    public int count;

    @ApiModelProperty(value = "总条数")
    public long total;

    @ApiModelProperty(value = "总页数")
    public long pages;

    @ApiModelProperty(value = "关键字")
    public String kw;
}
