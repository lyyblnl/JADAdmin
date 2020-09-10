package com.jad.JADAdmin.SystemForm.ServiceImpl;

import com.jad.JADAdmin.SystemForm.Mapper.FormTableMapper;
import com.jad.JADAdmin.SystemForm.Model.FormTable;
import com.jad.JADAdmin.SystemForm.Service.FormTableService;
import com.jad.JADAdmin.common.base.service.BaseServiceImpl;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;
import org.springframework.stereotype.Service;

/**
 * 表单 - 业务实现类
 */
@Service
public class FormTableServiceImpl extends BaseServiceImpl<FormTable, FormTableMapper> implements FormTableService {
    /**
     * 授权认证字段
     */
    private String authorizeField="databaseId,namespace,names,entityName,tableName,isLD,isFk,remark,enable";

    /**
     * 添加表单
     *
     * @param entity 表单信息
     * @return 执行结果
     */
    @Override
    public JsonResult create(FormTable entity) {
        JsonResult result = new JsonResult("添加失败");
        int row = super.insert(entity);
        if (row > 0) {
            result.setMsg("添加成功").setSuccess(true);
        }
        return result;
    }

    /**
     * 删除表单
     *
     * @param id 表单id
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
     * 删除多个表单
     *
     * @param ids 表单id列表
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
     * 修改表单
     *
     * @param entity 表单信息
     * @return 执行结果
     */
    @Override
    public JsonResult edit(FormTable entity) {
        JsonResult result = new JsonResult("修改失败");
        if (!super.exist(entity.getId())) {
            return result.setMsg("修改失败，数据不存在");
        }
        int row = super.update(entity, authorizeField);
        if (row > 0) {
            result.setMsg("修改成功").setSuccess(true);
        }
        return result;
    }

    /**
     * 分页获取表单
     *
     * @param search 表单信息
     * @return 执行结果
     */
    @Override
    public JsonResult getList(SearchLayer search) {
        return super.getPageResult(search);
    }

    /**
     * 表单详情
     *
     * @param id 表单id
     * @return 执行结果
     */
    @Override
    public JsonResult detail(String id) {
        JsonResult result = new JsonResult("数据不存在");
        if (!super.exist(id)) {
            return result;
        }
        FormTable data = super.findKey(id);
        if (data != null) {
            result.setMsg("查询成功").setSuccess(true).setData(data);
        }
        return result;
    }

    /**
     * 表单是否存在
     *
     * @param id 表单id
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
}
