package com.soft2242.one.dao;


import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import com.soft2242.one.vo.OrderDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

	OrderDetailVO getInfoById(@Param("orderId") Long orderId);

	OrderDetailVO getUserInfo(@Param("userId") Long userId);

	//根据id查询物业信息
	OrderDetailVO getPropertyInfo(@Param("userId") Long userId);

	//根据admin_id查询物业信息
	OrderDetailVO getInfo(@Param("userId") Long userId);

	RepairRecordEntity getEmployeeIds(@Param("orderId") Long orderId);
}