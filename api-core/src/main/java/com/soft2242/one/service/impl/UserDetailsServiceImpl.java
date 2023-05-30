package com.soft2242.one.service.impl;

import com.soft2242.one.dao.AccountDao;
import com.soft2242.one.dao.UserDao;
import com.soft2242.one.entity.AccountEntity;
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
 * @program : community-client-api
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
        AccountEntity accountEntity = accountDao.selectById(account.getId());
        if(accountEntity == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        UserDetail userDetail = UserDetail.builder()
                .id(accountEntity.getId())
                .username(account.getPhone())
                .password(account.getPassword())
                .mobile(account.getPhone())
                .isSuperAdmin(accountEntity.getSuperAdmin() )
                .status(1)
                .isEnabled(false)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .build();
        userDetail.setEnabled(true);


        userDetail.setAuthoritySet(new HashSet<>());

        return userDetail;
    }
}
