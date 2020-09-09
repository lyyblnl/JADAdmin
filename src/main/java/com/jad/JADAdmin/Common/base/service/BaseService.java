package com.jad.JADAdmin.common.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;

import java.util.List;

public interface BaseService<T> extends IService<T> {
    /**
     * 添加数据
     *
     * @param entity 数据实体
     * @return 影响行数
     */
    int insert(T entity);

    /**
     * 删除数据
     *
     * @param id 数据id
     * @return 影响行数
     */
    int delete(String id);

    /**
     * 删除多条数据
     *
     * @param ids 数据id集合
     * @return 影响行数
     */
    int deleteArray(String[] ids);

    /**
     * 修改数据
     *
     * @param entity 数据实体
     * @return 影响行数
     */
    int update(T entity);

    /**
     * 分页查询
     *
     * @param search 分页参数
     * @return 执行结果
     */
    JsonResult getPageResult(SearchLayer search);

    /**
     * 分页查询
     *
     * @param search 分页参数
     * @return 执行结果
     */
    List<T> getPageData(SearchLayer search);

    /**
     * 分页查询
     *
     * @param search 分页参数
     * @return 执行结果
     */
    IPage<T> getIPage(SearchLayer search);

    /**
     * 获取数据
     *
     * @param id 数据id
     * @return 数据实体
     */
    T findKey(String id);

    /**
     * 数据是否存在
     *
     * @param id 数据id
     * @return 是否存在
     */
    boolean exist(String id);
}
