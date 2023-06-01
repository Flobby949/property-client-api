package com.soft2242.one.dao;

import com.soft2242.one.entity.PassRecordEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
* 通行记录
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface PassRecordDao extends BaseDao<PassRecordEntity> {

}