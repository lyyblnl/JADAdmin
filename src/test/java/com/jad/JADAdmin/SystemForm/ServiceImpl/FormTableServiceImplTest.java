package com.jad.JADAdmin.SystemForm.ServiceImpl;

import com.jad.JADAdmin.SystemForm.Model.FormTable;
import com.jad.JADAdmin.common.model.JsonResult;
import com.jad.JADAdmin.common.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormTableServiceImplTest {
    @Resource
    private FormTableServiceImpl service;

    @Test
    public void create() {
        FormTable formTable = new FormTable();
        formTable.setDatabaseId(UUIDUtil.getUUID());
        formTable.setNamespace("form");
        formTable.setNames("表单字段");
        formTable.setEntityName("FromField");
        formTable.setTableName("form_field");
        formTable.setIsLD(false);
        formTable.setIsFk(false);
        formTable.setRemark("表单字段");
        JsonResult result = service.create(formTable);
        Assert.assertTrue(result.success);
    }

    @Test
    public void del() {
    }

    @Test
    public void delArray() {
    }

    @Test
    public void edit() {
        FormTable formTable = service.findKey("c66ffa3acc3a4fabbfd825a879f39940");
        JsonResult result = service.edit(formTable);
        Assert.assertTrue(result.success);
    }

    @Test
    public void getList() {
    }

    @Test
    public void detail() {
    }

    @Test
    public void existed() {
    }
}