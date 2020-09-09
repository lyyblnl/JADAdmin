package com.jad.JADAdmin.SysUserInfo.Mapper;

import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;
import com.jad.JADAdmin.common.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper
 */
@Mapper
public interface SysUserInfoMapper extends BaseMapper<SysUserInfo> {
    List<SysUserInfo> getListByAccount(String account);
}
