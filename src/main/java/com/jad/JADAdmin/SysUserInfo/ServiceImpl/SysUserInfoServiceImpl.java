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

    @Resource
    private SysUserInfoMapper mapper;

    /**
     * 添加用户
     *
     * @param entity 用户信息
     * @return 执行结果
     */
    @Override
    public JsonResult create(SysUserInfo entity) {
        JsonResult result = new JsonResult("添加失败");
        int row = super.insert(entity);
        if (row > 0) {
            result.setMsg("添加成功").setSuccess(true);
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
    public JsonResult del(String id) {
        JsonResult result = new JsonResult("删除失败");
        if (!super.exist(id)) {
            return result.setMsg("删除失败，数据不存在");
        }
        int row = super.delete(id);
        if (row > 0) {
            result.setMsg("删除成功").setSuccess(true);
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
    public JsonResult delArray(String[] ids) {
        JsonResult result = new JsonResult("批量删除失败");
        if (ids == null || ids.length == 0) {
            return result.setMsg("未选中删除数据！");
        }
        int row = super.deleteArray(ids);
        if (row > 0) {
            String msg = String.format("批量删除成功，共%d条，成功%d条，失败%d条", ids.length, row, ids.length - row);
            result.setMsg(msg).setSuccess(true);
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
        JsonResult result = new JsonResult("修改失败");
        if (!super.exist(entity.getId())) {
            return result.setMsg("修改失败，数据不存在");
        }
        int row = super.update(entity);
        if (row > 0) {
            result.setMsg("修改成功").setSuccess(true);
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
        JsonResult result = new JsonResult("数据不存在");
        if (!super.exist(id)) {
            return result;
        }
        SysUserInfo data = super.findKey(id);
        if (data != null) {
            result.setMsg("查询成功").setSuccess(true).setData(data);
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
    public JsonResult existed(String id) {
        JsonResult result = new JsonResult("数据不存在");
        boolean exist = super.exist(id);
        result.data = exist;
        if (exist) {
            result.setMsg("数据存在");
        }
        return result;
    }

    /**
     * 根据账号查找用户
     *
     * @param account 账号
     * @return 执行结果
     */
    public JsonResult getListByAccount(String account) {
        JsonResult result = new JsonResult("查找失败");
        List<SysUserInfo> data = mapper.getListByAccount(account);
        if (data != null) {
            result.data = data;
            result.success = true;
            result.msg = "查询成功";
        }
        return result;
    }
}
