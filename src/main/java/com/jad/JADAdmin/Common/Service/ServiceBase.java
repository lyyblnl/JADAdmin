package com.jad.JADAdmin.Common.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;

import javax.annotation.Resource;
import java.util.List;

public class ServiceBase<T> {
    @Resource
    protected JsonResult result;
    @Resource
    private BaseMapper<T> baseMapper;

    /**
     * 分页查询
     *
     * @param search
     * @return
     */
    protected JsonResult getPageResult(SearchLayer search) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        Page<T> page = new Page<>(search.current, search.size);
        IPage<T> iPage = baseMapper.selectPage(page, wrapper);
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
}
