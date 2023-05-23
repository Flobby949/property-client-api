package com.soft2242.one.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 登录状态枚举
 * @create : 2023-04-23 17:49
 **/

@Getter
@AllArgsConstructor
public enum LoginOperationEnum {
    /**
     * 登录成功
     */
    LOGIN_SUCCESS(0),
    /**
     * 退出成功
     */
    LOGOUT_SUCCESS(1),
    /**
     * 验证码错误
     */
    CAPTCHA_FAIL(2),
    /**
     * 账号密码错误
     */
    ACCOUNT_FAIL(3);

    private final int value;
}

