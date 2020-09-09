package com.jad.JADAdmin.SystemForm.Service;

import com.jad.JADAdmin.SystemForm.Model.FormTable;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;

/**
 * 表单 - 业务接口
 */
public interface FormTableService {
    /**
     * 添加表单
     *
     * @param formTable 表单信息
     * @return 执行结果
     */
    JsonResult create(FormTable formTable);

    /**
     * 删除表单
     *
     * @param id 表单id
     * @return 执行结果
     */
    JsonResult del(String id);

    /**
     * 删除多个表单
     *
     * @param ids 表单id列表
     * @return 执行结果
     */
    JsonResult delArray(String[] ids);

    /**
     * 修改表单
     *
     * @param formTable 表单信息
     * @return 执行结果
     */
    JsonResult edit(FormTable formTable);

    /**
     * 分页获取表单
     *
     * @param search 表单信息
     * @return 执行结果
     */
    JsonResult getList(SearchLayer search);

    /**
     * 表单详情
     *
     * @param id 表单id
     * @return 执行结果
     */
    JsonResult detail(String id);

    /**
     * 表单是否存在
     *
     * @param id 表单id
     * @return 执行结果
     */
    JsonResult existed(String id);
}
