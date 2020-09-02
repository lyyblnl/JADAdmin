package com.jad.JADAdmin.Common.Utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
     * @return
     */
    public static String nowFormat() {
        return nowFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化日期
     * @return
     */
    public static String nowFormat(String format) {
        if (format == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(now());
    }
}
