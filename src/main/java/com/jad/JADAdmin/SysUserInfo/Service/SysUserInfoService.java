package com.jad.JADAdmin.SysUserInfo.Service;

import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;
import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;

/**
 * 用户 - 业务接口
 */
public interface SysUserInfoService {
    /**
     * 添加用户
     * @param sysUserInfo 用户信息
     * @return 执行结果
     */
    public JsonResult<SysUserInfo> create(SysUserInfo sysUserInfo);

    /**
     * 删除用户
     * @param id 用户id
     * @return 执行结果
     */
    public JsonResult<SysUserInfo> delete(String id);

    /**
     * 删除多个用户
     * @param id 用户id
     * @return 执行结果
     */
    public JsonResult<SysUserInfo> deleteArray(String id);

    /**
     * 修改用户
     * @param sysUserInfo 用户信息
     * @return 执行结果
     */
    public JsonResult<SysUserInfo> edit(SysUserInfo sysUserInfo);

    /**
     * 分页获取用户
     * @param search 用户信息
     * @return 执行结果
     */
    public JsonResult<SysUserInfo> getList(SearchLayer search);

    /**
     * 用户详情
     * @param id 用户id
     * @return 执行结果
     */
    public JsonResult<SysUserInfo> detail(String id);
}
