package com.cxxwl96.ADAdmin.SystemUserInfo.Controller;

import com.cxxwl96.ADAdmin.SystemUserInfo.Mapper.SysUserInfoMapper;
import com.cxxwl96.ADAdmin.SystemUserInfo.Model.SysUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户管理相关接口")
@RestController
@RequestMapping("SystemUserInfo")
public class SysUserInfoController {
    @Resource
    private SysUserInfoMapper sysUserInfo;

    @ApiOperation("添加用户的接口")
    @GetMapping("test")
    public List<SysUserInfo> test(){
        List<SysUserInfo> list = sysUserInfo.get();

        return list;
    }
}
