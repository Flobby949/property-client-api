package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 用户账号信息表
 * @create : 2023-05-23 15:21
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_account")
public class AccountEntity extends BaseEntity {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 支付密码
     */
    private String payPassword;
    /**
     * open_id
     */
    private String wechatId;
    /**
     * 状态
     * 0-启用
     * 1-禁用
     */
    private Integer status;
}
