package com.github.wecoming.mybatis.generator.constant;

/**
 * 对应数据表的istatus 逻辑删除（1有效，0删除）
 */
public enum IStatusEnum {
    DELETE((short) 0), AVAILABLE((short) 1);

    private short value;

    IStatusEnum(short value) {
        this.value = value;
    }

    public Short value() {
        return value;
    }
}
