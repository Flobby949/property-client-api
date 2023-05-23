package com.soft2242.one.service.impl;

import com.soft2242.one.common.exception.ServerException;
import com.soft2242.one.security.cache.TokenStoreCache;
import com.soft2242.one.security.user.UserDetail;
import com.soft2242.one.security.utils.TokenUtils;
import com.soft2242.one.service.AuthService;
import com.soft2242.one.vo.SysTokenVO;
import com.soft2242.one.vo.AccountLoginVO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 实现类
 * @create : 2023-05-23 15:27
 **/

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final TokenStoreCache tokenStoreCache;

    @Override
    public SysTokenVO loginByAccount(AccountLoginVO login) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getPhone(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存，accessToken默认过期时间为24小时
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        // TODO 记录日志
        // 从缓存中删除用户
        tokenStoreCache.deleteUser(accessToken);
    }

    @Override
    public boolean sendCode(String mobile) {
        return false;
    }
}
