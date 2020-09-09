package com.jad.JADAdmin.SysUserInfo.ServiceImpl;

import com.jad.JADAdmin.SysUserInfo.Mapper.SysUserInfoMapper;
import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;
import com.jad.JADAdmin.SysUserInfo.Service.SysUserInfoService;
import com.jad.JADAdmin.common.base.service.BaseServiceImpl;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 - 业务实现类
 */
@Service
public class SysUserInfoServiceImpl extends BaseServiceImpl<SysUserInfo, SysUserInfoMapper> implements SysUserInfoService {
    // TODO：不能使用单例result
    @Resource
    private JsonResult result;
    @Resource
    private SysUserInfoMapper mapper;

    /**
     * 添加用户
     *
     * @param sysUserInfo 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult create(SysUserInfo sysUserInfo) {
        return null;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult del(String id) {
        return null;
    }

    /**
     * 删除多个用户
     *
     * @param ids 用户id列表
     * @return 执行结果
     */
    @Override
    public JsonResult delArray(String[] ids) {
        return null;
    }

    /**
     * 修改用户
     *
     * @param sysUserInfo 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult edit(SysUserInfo sysUserInfo) {
        return null;
    }

    /**
     * 分页获取用户
     *
     * @param search 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult getList(SearchLayer search) {
        return super.getPageResult(search);
    }

    /**
     * 用户详情
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult detail(String id) {
        return null;
    }

    /**
     * 用户是否存在
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult existed(String id) {
        return null;
    }

    /**
     * 根据账号查找用户
     * @param account 账号
     * @return 执行结果
     */
    public JsonResult getListByAccount(String account){
        List<SysUserInfo> data =  mapper.getListByAccount(account);
        if(data!=null){
            result.data = data;
            result.success = true;
            result.msg = "查询成功";
        }
        return result;
    }
}
