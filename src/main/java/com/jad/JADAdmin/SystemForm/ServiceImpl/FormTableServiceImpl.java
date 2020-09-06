package com.jad.JADAdmin.SystemForm.ServiceImpl;

import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;
import com.jad.JADAdmin.Common.Service.BaseService.BaseService;
import com.jad.JADAdmin.SystemForm.Model.FormTable;
import com.jad.JADAdmin.SystemForm.Service.FormTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 表单 - 业务实现类
 */
@Service
public class FormTableServiceImpl implements FormTableService {
    @Resource
    private JsonResult result;
    @Resource
    private BaseService<FormTable> service;

    /**
     * 添加表单
     *
     * @param entity 表单信息
     * @return 执行结果
     */
    @Override
    public JsonResult create(FormTable entity) {
        int row = service.insert(entity);
        if (row > 0) {
            result.msg = "添加成功";
            result.success = true;
        } else {
            result.msg = "添加失败";
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
    public JsonResult delete(String id) {
        if (!service.exist(id)) {
            result.msg = "数据不存在";
            return result;
        }
        int row = service.delete(id);
        if (row > 0) {
            result.msg = "删除成功";
            result.success = true;
        } else {
            result.msg = "删除失败";
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
    public JsonResult deleteArray(String[] ids) {
        if (ids == null || ids.length == 0) {
            result.msg = "未选中删除数据！";
            return result;
        }
        int row = service.deleteArray(ids);
        if (row > 0) {
            result.msg = String.format("批量删除成功，共%d条，成功%d条，失败%d条", ids.length, row, ids.length - row);
            result.success = true;
        } else {
            result.msg = "删除失败";
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
    public JsonResult update(FormTable entity) {
        if (!service.exist(entity.getId())) {
            result.msg = "数据不存在";
            return result;
        }
        int row = service.update(entity);
        if (row > 0) {
            result.msg = "修改成功";
            result.success = true;
        } else {
            result.msg = "修改失败";
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
        return service.getPageResult(search);
    }

    /**
     * 表单详情
     *
     * @param id 表单id
     * @return 执行结果
     */
    @Override
    public JsonResult detail(String id) {
        if (!service.exist(id)) {
            result.msg = "数据不存在";
            return result;
        }
        FormTable data = service.findKey(id);
        if (data != null) {
            result.data = data;
            result.msg = "查询成功";
            result.success = true;
        } else {
            result.msg = "查询失败";
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
    public JsonResult exist(String id) {
        boolean exist = service.exist(id);
        result.data = service.exist(id);
        if (exist) {
            result.msg = "数据存在";
        } else {
            result.msg = "数据不存在";
        }
        return result;
    }
}
