package com.soft2242.one.common.utils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.soft2242.one.common.exception.ServerException;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 校验工具类
 * @create : 2023-04-23 17:00
 **/
public class AssertUtils {

    public static void isBlank(String str, String variable) {
        if (StrUtil.isBlank(str)) {
            throw new ServerException(variable + "不能为空");
        }
    }

    public static void isNull(Object object, String variable) {
        if (object == null) {
            throw new ServerException(variable + "不能为空");
        }
    }

    public static void isArrayEmpty(Object[] array, String variable) {
        if (ArrayUtil.isEmpty(array)) {
            throw new ServerException(variable + "不能为空");
        }
    }

}