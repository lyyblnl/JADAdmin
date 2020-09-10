package com.jad.JADAdmin.common.exception;

/**
 * 字段未找到异常
 */
public class FieldNotExistException extends Exception {
    //字段名
    private String fieldName;

    public FieldNotExistException(String fieldName) {
        super(String.format("“%s”字段不存在", fieldName));
        this.fieldName = fieldName;
    }
}
