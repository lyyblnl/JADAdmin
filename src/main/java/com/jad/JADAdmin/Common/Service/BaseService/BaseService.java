package com.jad.JADAdmin.Common.Service.BaseService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;
import com.jad.JADAdmin.Common.Utils.DateUtil;
import com.jad.JADAdmin.Common.Utils.EntityUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BaseService<T> implements BaseServiceInterface<T> {
    @Resource
    private JsonResult result;
    @Resource
    public BaseMapper<T> mapper;

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
        boolean success = EntityUtil.setFieldsValue(entity, kw);
        if (!success) {
            return 0;
        }
        return mapper.insert(entity);
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
        return mapper.deleteById(id);
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
        return mapper.deleteBatchIds(Arrays.asList(ids));
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
        boolean success = EntityUtil.setFieldsValue(entity, kw);
        if (!success) {
            return 0;
        }
        return mapper.updateById(entity);
    }

    /**
     * 分页查询
     *
     * @param search 分页参数
     * @return 执行结果
     */
    @Override
    public JsonResult getPageResult(SearchLayer search) {
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
        } else {
            result.msg = "查询失败";
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
        IPage<T> iPage = mapper.selectPage(page, wrapper);
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
        return mapper.selectById(id);
    }

    /**
     * 数据是否存在
     *
     * @param id 数据id
     * @return 是否存在
     */
    @Override
    public boolean exist(String id) {
        int row = mapper.selectCount(new QueryWrapper<T>().eq("id", id));
        return row > 0;
    }
}
