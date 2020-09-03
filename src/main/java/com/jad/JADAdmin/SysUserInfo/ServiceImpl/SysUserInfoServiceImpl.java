package com.jad.JADAdmin.SysUserInfo.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;
import com.jad.JADAdmin.Common.Service.ServiceBase;
import com.jad.JADAdmin.SysUserInfo.Mapper.SysUserInfoMapper;
import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;
import com.jad.JADAdmin.SysUserInfo.Service.SysUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 用户 - 业务实现类
 */
@Service
public class SysUserInfoServiceImpl extends ServiceBase implements SysUserInfoService {
    @Resource
    private SysUserInfoMapper sysUserInfoMapper;

    /**
     * 添加用户
     *
     * @param entity 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult create(SysUserInfo entity) {
        int row = sysUserInfoMapper.insert(entity);
        if (row > 0) {
            result.msg = "添加成功";
            result.success = true;
        } else {
            result.msg = "添加失败";
        }
        return result;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult delete(String id) {
        if (!Exist(id)) {
            result.msg = "数据不存在";
            return result;
        }
        int row = sysUserInfoMapper.deleteById(id);
        if (row > 0) {
            result.msg = "删除成功";
            result.success = true;
        } else {
            result.msg = "删除失败";
        }
        return result;
    }

    /**
     * 删除多个用户
     *
     * @param ids 用户id列表
     * @return 执行结果
     */
    @Override
    public JsonResult deleteArray(String[] ids) {
        if (ids == null || ids.length == 0) {
            result.msg = "未选中删除数据！";
        }
        int row = sysUserInfoMapper.deleteBatchIds(Arrays.asList(ids));
        if (row > 0) {
            result.msg = String.format("批量删除成功，共%d条", row);
            result.success = true;
        } else {
            result.msg = "删除失败";
        }
        return result;
    }

    /**
     * 修改用户
     *
     * @param entity 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult edit(SysUserInfo entity) {
        if (!Exist(entity.getId())) {
            result.msg = "数据不存在";
            return result;
        }
        int row = sysUserInfoMapper.updateById(entity);
        if (row > 0) {
            result.msg = "修改成功";
            result.success = true;
        } else {
            result.msg = "修改失败";
        }
        return result;
    }

    /**
     * 分页获取用户
     *
     * @param search 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult getList(SearchLayer search) {
        return getPageResult(search);
    }

    /**
     * 用户详情
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult detail(String id) {
        if (!Exist(id)) {
            result.msg = "数据不存在";
            return result;
        }
        SysUserInfo data = sysUserInfoMapper.selectById(id);
        if(data!=null){
            result.data = data;
            result.msg = "查询成功";
            result.success = true;
        } else {
            result.msg = "查询失败";
        }
        return result;
    }

    /**
     * 用户是否存在
     *
     * @param id 用户id
     * @return 执行结果
     */
    @Override
    public JsonResult exist(String id) {
        int row = sysUserInfoMapper.selectCount(new QueryWrapper<SysUserInfo>().eq("id", id));
        result.data = row == 1;
        if (row == 1) {
            result.msg = "数据存在";
        } else {
            result.msg = "数据不存在";
        }
        return result;
    }

    /**
     * 用户是否存在
     *
     * @param id 用户id
     * @return 执行结果
     */
    private boolean Exist(String id) {
        int row = sysUserInfoMapper.selectCount(new QueryWrapper<SysUserInfo>().eq("id", id));
        return row == 1;
    }
}
