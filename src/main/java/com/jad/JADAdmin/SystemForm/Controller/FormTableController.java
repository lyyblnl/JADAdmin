package com.jad.JADAdmin.SystemForm.Controller;

import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;
import com.jad.JADAdmin.SystemForm.Model.FormTable;
import com.jad.JADAdmin.SystemForm.Service.FormTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "表单管理相关接口")
@RestController
@RequestMapping("FormTable")
public class FormTableController {
    @Resource
    private FormTableService service;

    @ApiOperation("分页获取用户接口")
    @GetMapping("getList")
    public JsonResult getList(SearchLayer search){
        return service.getList(search);
    }
}
