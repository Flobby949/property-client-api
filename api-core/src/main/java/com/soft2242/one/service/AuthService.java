package com.soft2242.one.service;

import com.soft2242.one.vo.AccountLoginVO;
import com.soft2242.one.vo.RepasswordVO;
import com.soft2242.one.vo.SysTokenVO;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 认证服务
 * @create : 2023-05-23 15:26
 **/

public interface AuthService {

    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(AccountLoginVO login);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @return boolean
     */
    boolean sendCode(String mobile);

    /**
     * 修改密码
     *
     * @param repasswordVO 修改密码信息
     * @return boolean
     */
    boolean repassword(RepasswordVO repasswordVO);
}
