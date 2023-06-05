package com.soft2242.one.dao;

import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import com.soft2242.one.vo.RepairRecordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 报修处理表
*
* @author litao
* @since 1.0.0 2023-06-05
*/
@Mapper
public interface RepairRecordDao extends BaseDao<RepairRecordEntity> {
	List<RepairRecordVO> getRepairRecordList(Map<String,Object> params);
}