package com.soft2242.one.security.user;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : Security用户
 * @create : 2023-04-23 17:16
 **/
public class SecurityUser {

    /**
     * 获取用户信息
     */
    public static UserDetail getUser() {
        UserDetail user;
        try {
            user = (UserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return new UserDetail();
        }

        return user;
    }

    /**
     * 获取用户ID
     */
    public static Long getUserId() {
        return getUser().getId();
    }

}