package com.jad.JADAdmin.common.utils;

import java.util.UUID;

/**
 * UUID 工具类
 */
public class UUIDUtil {
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
