package com.jad.JADAdmin.Common.Model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jad.JADAdmin.Common.Utils.UUIDUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实体根类
 */
@ApiModel(value = "实体根类")
@Data
public class RootEntity {
    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    public RootEntity() {
        this.id = UUIDUtil.getUUID();
    }
}
