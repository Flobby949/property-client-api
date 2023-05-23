package com.soft2242.one.dao;

import com.soft2242.one.entity.UserEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 用户dao
 * @create : 2023-05-23 15:23
 **/

@Mapper
public interface UserDao extends BaseDao<UserEntity> {
}
