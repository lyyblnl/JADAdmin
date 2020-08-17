package com.cxxwl96.ADAdmin.SystemUserInfo.Model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class SysUserInfo {
    @TableId
    private String id;

    private String name;

    @TableField("CreateTime")
    private Timestamp CreateTime;
}
