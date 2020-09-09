package com.jad.JADAdmin.common.utils;

/**
 * 字符串 工具类
 */
public class StringUtil {
    /**
     * 判断字符串是否为null
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        return str == null;
    }

    /**
     * 判断字符串是否为null或者空字符串
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串是否为null或者空白字符串
     *
     * @param str
     * @return
     */
    public static boolean isNullOrWhiteSpace(String str) {
        return str == null || (str.length() > 0 && str.replaceAll("\\s*", "").length() == 0);
    }

}
