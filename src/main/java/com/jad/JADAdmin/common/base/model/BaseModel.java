package com.jad.JADAdmin.common.base.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jad.JADAdmin.common.utils.UUIDUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 实体基类
 */
@ApiModel(value = "实体基类")
@Data
public class BaseModel<T extends BaseModel<T>> extends Model<T> {
    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT)
    private Timestamp updateTime;

    @ApiModelProperty(value = "修改人")
    @TableField(fill = FieldFill.INSERT)
    private String updateBy;

    @ApiModelProperty(value = "逻辑删除【未删除：true，已删除：false】")
    private Boolean enable;

    public BaseModel() {
        this.id = UUIDUtil.getUUID();
    }
}
