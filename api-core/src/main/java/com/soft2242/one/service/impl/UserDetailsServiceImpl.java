package com.soft2242.one.service.impl;

import com.soft2242.one.dao.AccountDao;
import com.soft2242.one.dao.UserDao;
import com.soft2242.one.entity.AccountEntity;
import com.soft2242.one.entity.UserEntity;
import com.soft2242.one.enums.UserStatusEnum;
import com.soft2242.one.security.user.UserDetail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : security登录实现类
 * @create : 2023-05-23 15:27
 **/

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountDao accountDao;
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountDao.getByPhone(username);
        if (accountEntity == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return getUserDetails(accountEntity);
    }

    private UserDetails getUserDetails(AccountEntity account) {
        UserEntity userEntity = userDao.selectById(account.getUserId());
        UserDetail userDetail = UserDetail.builder()
                .id(userEntity.getId())
                .username(account.getPhone())
                .password(account.getPassword())
                .realName(userEntity.getRealName())
                .avatar(userEntity.getAvatar())
                .gender(userEntity.getGender())
                .mobile(account.getPhone())
                .status(account.getStatus())
                .isEnabled(true)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .build();

        if (account.getStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

        userDetail.setAuthoritySet(new HashSet<>());

        return userDetail;
    }
}
