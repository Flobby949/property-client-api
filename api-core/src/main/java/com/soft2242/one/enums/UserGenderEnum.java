package com.soft2242.one.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 性别枚举
 * @create : 2023-04-23 17:48
 **/

@Getter
@AllArgsConstructor
public enum UserGenderEnum {
    /**
     * 男
     */
    MAN(1, "男"),
    /**
     * 女
     */
    WOMEN(2, "女"),
    /**
     * 保密
     */
    UNKNOWN(0,"保密");

    private final int value;
    private final String name;

    public static String getNameByValue(int value) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}
