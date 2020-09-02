package com.jad.JADAdmin.SysUserInfo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;

import java.util.List;

public interface SysUserInfoMapper extends BaseMapper<SysUserInfo> {
    List<SysUserInfo> get();
}
