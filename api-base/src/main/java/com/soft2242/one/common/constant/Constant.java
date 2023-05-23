package com.soft2242.one.common.constant;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 常量
 * @create : 2023-04-23 17:00
 **/
public interface Constant {
    /**
     * 根节点标识
     */
    Long ROOT = 0L;
    /**
     * 当前页码
     */
    String PAGE = "page";
    /**
     * 超级管理员
     */
    Integer SUPER_ADMIN = 1;
    /**
     * 禁用
     */
    Integer DISABLE = 0;
    /**
     * 启用
     */
    Integer ENABLE = 1;
    /**
     * 失败
     */
    Integer FAIL = 0;
    /**
     * 成功
     */
    Integer SUCCESS = 1;
    /**
     * OK
     */
    String OK = "OK";

    /**
     * mysql的driver
     */
    String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    String DEFAULT_PASSWORD = "123456";
}