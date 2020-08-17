package com.cxxwl96.ADAdmin.SystemUserInfo.Mapper;


import com.cxxwl96.ADAdmin.SystemUserInfo.Model.SysUserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserInfoMapperTest {
    @Resource
    private SysUserInfoMapper mapper;

    @Test
    public void get() {
        List<SysUserInfo> users = mapper.get();
        for (SysUserInfo user : users) {
            System.out.println(user);
        }
    }
}