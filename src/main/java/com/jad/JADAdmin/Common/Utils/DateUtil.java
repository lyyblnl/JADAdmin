package com.jad.JADAdmin.Common.Utils;

import java.sql.Timestamp;

/**
 * 日期 工具类
 */
public class DateUtil {
    public static Timestamp Now(){
        return new Timestamp(System.currentTimeMillis());
    }
}
