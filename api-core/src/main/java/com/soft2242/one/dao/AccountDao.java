package com.soft2242.one.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.common.enums.DeleteFlagEnum;
import com.soft2242.one.entity.AccountEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 账号dao
 * @create : 2023-05-23 15:22
 **/


@Mapper
public interface AccountDao extends BaseDao<AccountEntity> {

    /**
     * 默认方法
     * 根据手机号获取用户
     * @param phone 手机号
     * @return account
     */
    default AccountEntity getByPhone(String phone) {
        return this.selectOne(new QueryWrapper<AccountEntity>()
                .eq("phone", phone)
                .eq("deleted", DeleteFlagEnum.NOT_DELETED.getValue()));
    }
}
