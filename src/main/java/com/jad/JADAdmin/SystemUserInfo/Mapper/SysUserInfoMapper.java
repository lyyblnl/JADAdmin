package com.jad.JADAdmin.SystemUserInfo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jad.JADAdmin.SystemUserInfo.Model.SysUserInfo;

import java.util.List;

public interface SysUserInfoMapper extends BaseMapper<SysUserInfo> {
    List<SysUserInfo> get();
}
