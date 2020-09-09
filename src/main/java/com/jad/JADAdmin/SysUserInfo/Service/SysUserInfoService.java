package com.jad.JADAdmin.SysUserInfo.Service;

import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;

/**
 * 用户 - 业务接口
 */
public interface SysUserInfoService {
    /**
     * 添加用户
     *
     * @param entity 用户信息
     * @return 执行结果
     */
    JsonResult create(SysUserInfo entity);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 执行结果
     */
    JsonResult del(String id);

    /**
     * 删除多个用户
     *
     * @param ids 用户id列表
     * @return 执行结果
     */
    JsonResult delArray(String[] ids);

    /**
     * 修改用户
     *
     * @param entity 用户信息
     * @return 执行结果
     */
    JsonResult edit(SysUserInfo entity);

    /**
     * 分页获取用户
     *
     * @param search 用户信息
     * @return 执行结果
     */
    JsonResult getList(SearchLayer search);

    /**
     * 用户详情
     *
     * @param id 用户id
     * @return 执行结果
     */
    JsonResult detail(String id);

    /**
     * 用户是否存在
     *
     * @param id 用户id
     * @return 执行结果
     */
    JsonResult existed(String id);
}
