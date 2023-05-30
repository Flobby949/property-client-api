package com.soft2242.one.enums;

import lombok.Getter;

/**
 * @author : JinChenXing
 * @program : property-client-api
 * @description :
 * @create : 2023-05-29 16:30
 **/
@Getter
public enum SuperAdminEnum {
    IS_SUPER_ADMIN(1, "超级管理员"),
    NOT_SUPER_ADMIN(0, "非超级管理员");

    private final Integer code;
    private final String desc;

    SuperAdminEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
