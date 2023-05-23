package com.soft2242.one.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author : JinChenXing
 * @program : property-client-api
 * @description : 用户状态枚举
 * @create : 2023-04-23 17:46
 **/

@Getter
@AllArgsConstructor
public enum UserStatusEnum {
    /**
     * 停用
     */
    DISABLE(1, "停用"),
    /**
     * 正常
     */
    ENABLED(0, "正常");

    private final int value;
    private final String name;

    public static String getNameByValue(int value) {
        for (UserStatusEnum s : UserStatusEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (UserStatusEnum s : UserStatusEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}
