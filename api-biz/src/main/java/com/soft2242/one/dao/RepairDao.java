package com.soft2242.one.dao;


import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 报修表
*
* @author litao
* @since 1.0.0 2023-06-05
*/
@Mapper
public interface RepairDao extends BaseDao<RepairEntity> {
	List<RepairEntity>  getLists(Map<String,Object> parmas);
}