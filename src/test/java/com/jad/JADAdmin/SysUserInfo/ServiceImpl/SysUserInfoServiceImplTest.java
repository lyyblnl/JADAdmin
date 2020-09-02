package com.jad.JADAdmin.SysUserInfo.ServiceImpl;

import com.jad.JADAdmin.Common.Enum.Sex;
import com.jad.JADAdmin.Common.Model.JsonResult;
import com.jad.JADAdmin.Common.Model.SearchLayer;
import com.jad.JADAdmin.Common.Utils.DateUtil;
import com.jad.JADAdmin.SysUserInfo.Model.SysUserInfo;
import com.jad.JADAdmin.SysUserInfo.Service.SysUserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserInfoServiceImplTest {
    @Resource
    private SysUserInfoService sysUserInfoService;

    @Test
    public void create() {
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setAccount("cxxwl96");
        sysUserInfo.setPassword("password");
        sysUserInfo.setNames("成应奎");
        sysUserInfo.setAge(24);
        sysUserInfo.setBirthday(DateUtil.now());
        sysUserInfo.setSex(Sex.男);
        sysUserInfo.setEmail("cxxwl96@sina.com");
        sysUserInfo.setPhone("15100001111");
        sysUserInfo.setHeadImg("/head/head.jpg");
        JsonResult result = sysUserInfoService.create(sysUserInfo);
        Assert.assertTrue(result.success);
        System.out.println(result);
    }

    @Test
    public void delete() {
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setId("aaa");
        JsonResult addResult = sysUserInfoService.create(sysUserInfo);
        Assert.assertTrue(addResult.success);
        JsonResult delResult = sysUserInfoService.delete("aaa");
        Assert.assertTrue(delResult.success);
        System.out.println(delResult);
    }

    @Test
    public void deleteArray() {
        String[] ids = {"aaa", "bbb", "ccc"};
        for (String id : ids) {
            SysUserInfo sysUserInfo = new SysUserInfo();
            sysUserInfo.setId(id);
            JsonResult addResult = sysUserInfoService.create(sysUserInfo);
            Assert.assertTrue(addResult.success);
        }
        JsonResult delResult = sysUserInfoService.deleteArray(ids);
        Assert.assertTrue(delResult.success);
        System.out.println(delResult);
    }

    @Test
    public void edit() {
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setId("5b16b4f1051440fd9086bf7afe9a79c0");
        sysUserInfo.setNames("cxxwl96");
        JsonResult result = sysUserInfoService.edit(sysUserInfo);
        Assert.assertTrue(result.success);
        System.out.println(result);
    }

    @Test
    public void getList() {
        SearchLayer search = new SearchLayer();
        search.current=2;
        search.size=2;
        JsonResult result = sysUserInfoService.getList(search);
        Assert.assertTrue(result.success);
        System.out.println(result);
    }

    @Test
    public void detail() {
        JsonResult result = sysUserInfoService.detail("5b16b4f1051440fd9086bf7afe9a79c0");
        Assert.assertTrue(result.success);
        System.out.println(result.data);
    }

    @Test
    public void exist() throws IOException {
        URL url=new URL("http://www.bjtime.cn");//取得资源对象
        URLConnection uc=url.openConnection();//生成连接对象
        uc.connect(); //发出连接
        long ld=uc.getDate(); //取得网站日期时间
        Date date=new Date(ld); //转换为标准时间对象
        //分别取得时间中的小时，分钟和秒，并输出
        System.out.print(date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒");
    }
}