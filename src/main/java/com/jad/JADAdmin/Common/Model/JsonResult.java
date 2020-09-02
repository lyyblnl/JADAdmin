package com.jad.JADAdmin.Common.Model;

import org.springframework.stereotype.Component;

/**
 * 请求结果模型
 * @param <T>
 */
@Component
public class JsonResult<T> {
    /*返回代码*/
    public String code = "";
    /*请求状态*/
    public boolean success = false;
    /*返回消息*/
    public String msg = "请求失败";
    /*返回数据*/
    public T data;
    /*重定向url*/
    public String url;
}
