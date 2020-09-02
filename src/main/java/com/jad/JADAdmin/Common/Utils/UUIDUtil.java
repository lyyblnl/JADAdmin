package com.jad.JADAdmin.Common.Utils;

import java.util.UUID;

/**
 * UUID 工具类
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
