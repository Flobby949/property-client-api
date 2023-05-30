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
@TableName("sys_admin")
public class AccountEntity extends BaseEntity {
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 超级管理员   0：否   1：是
     */
    private Integer superAdmin;
    /**
     * 账号状态 (1:正常,2:停用,3:冻结,4:删除)
     */
    private Integer accountStatus;
    /**
     * 在线状态 (0：离线 1:在线)
     */
    private Integer onlineStatus;

    /**
     * token
     */
    private String token;
}
