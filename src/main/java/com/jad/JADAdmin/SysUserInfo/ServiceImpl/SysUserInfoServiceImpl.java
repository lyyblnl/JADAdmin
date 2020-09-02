package com.jad.JADAdmin.SysUserInfo.ServiceImpl;

import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;
import com.jad.JADAdmin.SysUserInfo.Mapper.SysUserInfoMapper;
import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;
import com.jad.JADAdmin.SysUserInfo.Service.SysUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户 - 业务实现类
 */
@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {
    @Resource
    private JsonResult<SysUserInfo> result;
    @Resource
    private SysUserInfoMapper sysUserInfoMapper;
    /**
     * 添加用户
     *
     * @param sysUserInfo 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult<SysUserInfo> create(SysUserInfo sysUserInfo) {
        return null;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult<SysUserInfo> delete(String id) {
        return null;
    }

    /**
     * 删除多个用户
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult<SysUserInfo> deleteArray(String id) {
        return null;
    }

    /**
     * 修改用户
     *
     * @param sysUserInfo 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult<SysUserInfo> edit(SysUserInfo sysUserInfo) {
        return null;
    }

    /**
     * 分页获取用户
     *
     * @param search 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult<SysUserInfo> getList(SearchLayer search) {
        return null;
    }

    /**
     * 用户详情
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult<SysUserInfo> detail(String id) {
        return null;
    }
}
