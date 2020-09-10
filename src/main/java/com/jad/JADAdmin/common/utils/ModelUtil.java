package com.jad.JADAdmin.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jad.JADAdmin.common.exception.FieldNotExistException;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 实体 工具类
 */
public class ModelUtil {

    /**
     * 判断obj对象是否拥有某个字段
     *
     * @param obj       对象
     * @param fieldName 字段名
     * @return 是否存在
     */
    public static Boolean isExistField(Object obj, String fieldName) {
        if (StringUtil.isNullOrEmpty(fieldName)) {
            return false;
        }
        Object o = JSON.toJSON(obj);
        JSONObject jsonObj = new JSONObject();
        if (o instanceof JSONObject) {
            jsonObj = (JSONObject) o;
        }
        boolean contains = jsonObj.containsKey(fieldName);
        return contains;
    }

    /**
     * 获取obj对象某个字段
     *
     * @param obj       对象
     * @param fieldName 字段名
     * @return 字段
     */
    public static Field getField(Object obj, String fieldName) throws FieldNotExistException {
        Class clazz = obj.getClass();
        Field field = FieldUtils.getField(clazz, fieldName, true);
        if (field == null) {
            throw new FieldNotExistException(fieldName);
        }
        return field;
    }

    /**
     * 获取obj对象某个字段类型
     *
     * @param obj       对象
     * @param fieldName 字段名
     * @return 字段类型 - com.jad.JADAdmin.common.constant.ClassType
     */
    public static String getFieldTypeName(Object obj, String fieldName) {
        try {
            Field field = getField(obj, fieldName);
            String typeName = field.getType().getTypeName(); // 字段类型名
            return typeName;
        } catch (FieldNotExistException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取obj对象某个字段值
     *
     * @param obj       对象
     * @param fieldName 字段名
     * @return 字段值
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        try {
            Field field = getField(obj, fieldName);
            Object value = field.get(obj);
            return value;
        } catch (FieldNotExistException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置obj对象中fieldName字段的值
     *
     * @param obj       对象
     * @param fieldName 字段名
     * @param value     字段值
     * @return 是否设置成功
     */
    public static boolean setFieldValue(Object obj, String fieldName, Object value) {
        try {
            Field field = getField(obj, fieldName);
            field.set(obj, value);
            return true;
        } catch (FieldNotExistException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 给obj对象的字段设置值
     *
     * @param obj 对象
     * @param kw  key-字段名，value-字段值
     * @return 是否全部设置成功
     */
    public static boolean setFieldsValue(Object obj, Map<String, Object> kw) {
        if (obj == null || kw == null || kw.size() == 0) {
            return false;
        }
        // 所有需要设值的字段是否设值成功
        boolean flag = true;
        try {
            Class entityClass = obj.getClass();
            // 得到所有字段，包括父类以及私有字段
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
