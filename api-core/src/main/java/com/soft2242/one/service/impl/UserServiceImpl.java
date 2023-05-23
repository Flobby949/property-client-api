package com.soft2242.one.service.impl;

import com.soft2242.one.dao.UserDao;
import com.soft2242.one.entity.UserEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 实现类
 * @create : 2023-05-23 15:24
 **/

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {
}
