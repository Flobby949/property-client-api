package com.soft2242.one.common.enums;

import lombok.Getter;

/**
 * @author : JinChenXing
 * @program : property-client-api
 * @description : 删除标记枚举
 * @create : 2023-04-21 08:55
 **/

@Getter
public enum DeleteFlagEnum {
    NOT_DELETED(0, "未删除"),
    HAD_DELETED(1, "已删除");

    DeleteFlagEnum(int value, String des) {
        this.value = value;
        this.des = des;
    }

    private int value;
    private String des;
}
