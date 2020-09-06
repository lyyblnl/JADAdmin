package com.jad.JADAdmin.SystemForm.Model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jad.JADAdmin.Common.Model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "表单实体")
@Data
@TableName("form_table")
public class FormTable extends BaseEntity {
    @ApiModelProperty(value = "数据库id")
    private String databaseId;
    @ApiModelProperty(value = "命名空间")
    private String namespace;
    @ApiModelProperty(value = "中文名称")
    private String names;
    @ApiModelProperty(value = "实体名称")
    private String entityName;
    @ApiModelProperty(value = "表单名称（命名空间_实体名称）")
    private String tableName;
    @ApiModelProperty(value = "是否逻辑删除")
    private boolean isLD;
    @ApiModelProperty(value = "是否作为外键表")
    private boolean isFk;
}
