package com.jad.JADAdmin.SystemForm.ServiceImpl;

import com.jad.JADAdmin.SystemForm.Mapper.FormTableMapper;
import com.jad.JADAdmin.SystemForm.Model.FormTable;
import com.jad.JADAdmin.SystemForm.Service.FormTableService;
import com.jad.JADAdmin.common.base.service.BaseServiceImpl;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 表单 - 业务实现类
 */
@Service
public class FormTableServiceImpl extends BaseServiceImpl<FormTable, FormTableMapper> implements FormTableService {
    @Resource
    private JsonResult result;

    /**
     * 添加表单
     *
     * @param formTable 表单信息
     * @return 执行结果
     */
    @Override
    public JsonResult create(FormTable formTable) {
        return null;
    }

    /**
     * 删除表单
     *
     * @param id 表单id
     * @return 执行结果
     */
    @Override
    public JsonResult del(String id) {
        return null;
    }

    /**
     * 删除多个表单
     *
     * @param ids 表单id列表
     * @return 执行结果
     */
    @Override
    public JsonResult delArray(String[] ids) {
        return null;
    }

    /**
     * 修改表单
     *
     * @param formTable 表单信息
     * @return 执行结果
     */
    @Override
    public JsonResult edit(FormTable formTable) {
        return null;
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
        return null;
    }

    /**
     * 表单是否存在
     *
     * @param id 表单id
     * @return 执行结果
     */
    @Override
    public JsonResult existed(String id) {
        return null;
    }
}
