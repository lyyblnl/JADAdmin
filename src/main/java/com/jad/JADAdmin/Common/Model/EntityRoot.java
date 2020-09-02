package com.jad.JADAdmin.Common.Model;

import com.jad.JADAdmin.Common.Utils.UUIDUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实体根类
 */
@ApiModel(value = "实体根类")
@Data
public class EntityRoot {
    @ApiModelProperty(value = "主键id")
    private String id;

    public EntityRoot() {
        this.id = UUIDUtil.getUUID();
    }
}
