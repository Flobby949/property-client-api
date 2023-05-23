package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 用户信息表
 * @create : 2023-05-23 15:21
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class UserEntity extends BaseEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 性别
     * 0-保密
     * 1-男
     * 2-女
     */
    private Integer gender;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 真名
     */
    private String realName;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 民族
     */
    private String nation;
    /**
     * 婚姻状况
     * 0-未婚
     * 1-已婚
     */
    private Integer marriage;
    /**
     * 户口类型
     * 0-城市户籍
     * 1-农村户籍
     */
    private Integer accountType;
    /**
     * 党派
     */
    private String party;
    /**
     * 户籍所在地
     */
    private String domicileLocation;
    /**
     * 居住类型
     * 0-长居
     * 1-短住
     */
    private Integer rentalType;
    /**
     * 暂住证
     */
    private String stayCard;
    /**
     * 住址
     */
    private String address;
}
