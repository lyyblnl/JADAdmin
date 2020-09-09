package com.jad.JADAdmin.SysUserInfo.Controller;

import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;
import com.jad.JADAdmin.SysUserInfo.ServiceImpl.SysUserInfoServiceImpl;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.model.SearchLayer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户管理相关接口")
@RestController
@RequestMapping("SysUserInfo")
public class SysUserInfoController {
    @Resource
    private SysUserInfoServiceImpl service;

    @ApiOperation("分页获取用户接口")
    @GetMapping("getList")
    public JsonResult getList(SearchLayer search) {
        return service.getList(search);
    }

    @ApiOperation("根据账号查找用户")
    @GetMapping("getListByAccount")
    public JsonResult getListByAccount(String account){
        return service.getListByAccount(account);
    }
}
