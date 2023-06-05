package com.soft2242.one.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.soft2242.one.common.cache.RedisCache;
import com.soft2242.one.common.exception.ServerException;
import com.soft2242.one.dao.AccountDao;
import com.soft2242.one.entity.AccountEntity;
import com.soft2242.one.entity.UserEntity;
import com.soft2242.one.security.cache.TokenStoreCache;
import com.soft2242.one.security.user.UserDetail;
import com.soft2242.one.security.utils.TokenUtils;
import com.soft2242.one.service.AuthService;
import com.soft2242.one.service.SmsService;
import com.soft2242.one.vo.AccountLoginVO;
import com.soft2242.one.vo.RepasswordVO;
import com.soft2242.one.vo.SysTokenVO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
    private final SmsService smsService;
    private final RedisCache redisCache;
    private final AccountDao accountDao;
    private final PasswordEncoder passwordEncoder;

    /***
     * @description 登录
     * @param login
     * @return
     */
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

        if (user.getIsSuperAdmin() == 1) {
            throw new ServerException("超级管理员不允许登录");
        }


        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存，accessToken默认过期时间为24小时
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    /**
     * 退出登录
     *
     * @param accessToken token
     */
    @Override
    public void logout(String accessToken) {
        // TODO 记录日志
        // 从缓存中删除用户
        tokenStoreCache.deleteUser(accessToken);
    }

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @return boolean
     */
    @Override
    public boolean sendCode(String mobile) {
        String randomNumbers = RandomUtil.randomNumbers(6);
        redisCache.set(mobile, randomNumbers, 60);
        HashMap<String, String> map = new HashMap<>();
        map.put("code", randomNumbers);
        boolean send = smsService.send(mobile, map);
        return send;
    }

    /**
     * 修改密码
     *
     * @param repasswordVO 修改密码信息
     * @return boolean
     */
    @Override
    public boolean repassword(RepasswordVO repasswordVO) {
        String o = (String) redisCache.get(repasswordVO.getPhone());
        if (o == null) {
            throw new ServerException("验证码已过期");
        }
        if (!o.equals(repasswordVO.getCode())) {
            throw new ServerException("验证码错误");
        }
        AccountEntity phone = accountDao.getByPhone(repasswordVO.getPhone());
        if (phone == null) {
            throw new ServerException("手机号不存在");
        }
        phone.setPassword(passwordEncoder.encode(repasswordVO.getPassword()));
        int i = accountDao.updateById(phone);
        if (i == 0) {
            throw new ServerException("修改失败");
        }
        return true;
    }

    @Override
    public AccountEntity getUserInfo(String phone) {
        AccountEntity byPhone = accountDao.getByPhone(phone);
        return byPhone;
    }
}
