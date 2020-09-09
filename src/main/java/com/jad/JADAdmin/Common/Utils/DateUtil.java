package com.jad.JADAdmin.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 日期 工具类
 */
public class DateUtil {
    /**
     * 获取系统当前时间
     *
     * @return 当前时间
     */
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static String nowFormat() {
        return nowFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static String nowFormat(String format) {
        if (format == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(now());
    }
}
