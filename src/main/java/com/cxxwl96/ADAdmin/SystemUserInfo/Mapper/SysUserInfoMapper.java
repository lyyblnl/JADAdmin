package com.cxxwl96.ADAdmin.SystemUserInfo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxxwl96.ADAdmin.SystemUserInfo.Model.SysUserInfo;

import java.util.List;

public interface SysUserInfoMapper extends BaseMapper<SysUserInfo> {
    List<SysUserInfo> get();
}
