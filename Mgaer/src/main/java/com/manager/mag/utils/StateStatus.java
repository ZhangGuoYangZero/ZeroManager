package com.manager.mag.utils;

/**
 * 分配状态枚举类
 */
public enum  StateStatus {
    // 未分配
    //枚举对象是静态生成的 运行既生成对象当运行时，UNSTATE和STATED就生成了
    UNSTATE(0),
    // 已分配
    STATED(1),

    //编号6

    DEFAULT(6);

    private Integer type;

    StateStatus(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
