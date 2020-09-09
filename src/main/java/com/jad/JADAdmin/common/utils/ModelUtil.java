package com.jad.JADAdmin.common.utils;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 实体 工具类
 */
public class ModelUtil {

    /**
     * 给obj对象的属性设置值
     *
     * @param obj 对象
     * @param kw  key-属性名，value-字段值
     * @return 是否全部设置成功
     */
    public static boolean setFieldsValue(Object obj, Map<String, Object> kw) {
        if (obj == null || kw == null || kw.size() == 0) {
            return false;
        }
        // 所有需要设值的属性是否设值成功
        boolean flag = true;
        try {
            Class entityClass = obj.getClass();
            // 得到所有属性，包括父类以及私有字段
            Field[] fields = FieldUtils.getAllFields(entityClass);
            // 遍历所需要设置的字段
            for (Map.Entry<String, Object> entry : kw.entrySet()) {
                // 当前字段是否设值成功
                boolean fieldFlag = false;
                // 遍历所有字段
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName().equals(entry.getKey())) {
                        // 设置可访问
                        fields[i].setAccessible(true);
                        // 设值
                        fields[i].set(obj, entry.getValue());
                        fieldFlag = true;
                        break;
                    }
                }
                if (!fieldFlag) {
                    flag = false;
                    throw new RuntimeException(String.format("“%s”字段不存在，设置值失败", entry.getKey()));
                }
            }
        } catch (IllegalAccessException | RuntimeException e) {
            // TODO: 添加 IllegalAccessException、RuntimeException错误日志
            e.printStackTrace();
        }
        return flag;
    }
}
