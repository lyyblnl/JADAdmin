package com.jad.JADAdmin.Common.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 实体基类
 */
@ApiModel(value = "实体基类")
@Data
public class BaseEntity extends RootEntity {
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "修改时间")
    private Timestamp updateTime;
    @ApiModelProperty(value = "修改人")
    private String updateBy;
    @ApiModelProperty(value = "逻辑删除【未删除：true，已删除：false】")
    private Boolean enable;
}
