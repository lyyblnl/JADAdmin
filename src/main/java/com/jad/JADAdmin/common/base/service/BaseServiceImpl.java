package com.jad.JADAdmin.common.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jad.JADAdmin.common.base.mapper.BaseMapper;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;
import com.jad.JADAdmin.common.utils.DateUtil;
import com.jad.JADAdmin.common.utils.ModelUtil;
import com.jad.JADAdmin.common.utils.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl<T, M extends BaseMapper<T>> extends ServiceImpl<M, T> implements BaseService<T> {
    /**
     * 添加数据
     *
     * @param entity 数据实体
     * @return 影响行数
     */
    @Override
    public int insert(T entity) {
        Map<String, Object> kw = new HashMap<>();
        kw.put("createTime", DateUtil.now());
        // TODO: 添加createBy
        // kw.put("createBy", "ce47775e95a3499e86ca191c3aaa6c87");
        boolean success = ModelUtil.setFieldsValue(entity, kw);
        if (!success) {
            return 0;
        }
        return super.getBaseMapper().insert(entity);
    }

    /**
     * 删除数据
     *
     * @param id 数据id
     * @return 影响行数
     */
    @Override
    public int delete(String id) {
        // TODO: 是否逻辑删除
        return super.getBaseMapper().deleteById(id);
    }

    /**
     * 删除多条数据
     *
     * @param ids 数据id集合
     * @return 影响行数
     */
    @Override
    public int deleteArray(String[] ids) {
        // TODO: 是否逻辑删除
        return super.getBaseMapper().deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 修改数据
     *
     * @param entity 数据实体
     * @return 影响行数
     */
    @Override
    public int update(T entity) {
        Map<String, Object> kw = new HashMap<>();
        kw.put("updateTime", DateUtil.now());
        // TODO: 添加updateBy
        // kw.put("updateBy", "ce47775e95a3499e86ca191c3aaa6c87");
        boolean success = ModelUtil.setFieldsValue(entity, kw);
        if (!success) {
            return 0;
        }
        return super.getBaseMapper().updateById(entity);
    }

    /**
     * 根据id修改数据
     * - 修改指定字段
     * - fields 指定字段 - 每个字段由英文或中文“,”分隔。格式："field1,field2,field3"。
     *
     * @param entity 数据实体
     * @param fields 指定字段
     * @return 影响行数
     */
    @Override
    public int update(T entity, String fields) {
        return 0;
    }

    /**
     * 根据id修改数据
     * - 修改指定字段
     *
     * @param entity 数据实体
     * @param fields 指定字段数组
     * @return 影响行数
     */
    @Override
    public int update(T entity, String[] fields) {

        for (String field : fields) {
            if (!StringUtil.isNullOrEmpty(field)) {
                continue;
            }
            // TODO：判断实体里面是否存在某个属性
        }
        return 0;
    }

    /**
     * 分页查询
     *
     * @param search 分页参数
     * @return 执行结果
     */
    @Override
    public JsonResult getPageResult(SearchLayer search) {
        JsonResult result = new JsonResult("查询失败");
        IPage<T> iPage = getIPage(search);
        List<T> data = iPage.getRecords();
        search.count = data.size();
        search.total = iPage.getTotal();
        search.pages = iPage.getPages();
        result.search = search;
        if (data != null) {
            result.data = data;
            result.msg = "查询成功";
            result.success = true;
        }
        return result;
    }

    /**
     * 分页查询
     *
     * @param search 分页参数
     * @return 执行结果
     */
    @Override
    public List<T> getPageData(SearchLayer search) {
        IPage<T> iPage = getIPage(search);
        List<T> data = iPage.getRecords();
        return data;
    }

    /**
     * 分页查询
     *
     * @param search 分页参数
     * @return 执行结果
     */
    @Override
    public IPage<T> getIPage(SearchLayer search) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        Page<T> page = new Page<>(search.current, search.size);
        IPage<T> iPage = super.getBaseMapper().selectPage(page, wrapper);
        return iPage;
    }

    /**
     * 获取数据
     *
     * @param id 数据id
     * @return 数据实体
     */
    @Override
    public T findKey(String id) {
        return super.getBaseMapper().selectById(id);
    }

    /**
     * 数据是否存在
     *
     * @param id 数据id
     * @return 是否存在
     */
    @Override
    public boolean exist(String id) {
        int row = super.getBaseMapper().selectCount(new QueryWrapper<T>().eq("id", id));
        return row > 0;
    }
}
