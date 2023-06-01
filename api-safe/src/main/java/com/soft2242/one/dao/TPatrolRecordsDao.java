package com.soft2242.one.dao;

import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import com.soft2242.one.vo.TPatrolRecordsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Mapper

public interface TPatrolRecordsDao extends BaseDao<PatrolRecordsEntity> {
    List<TPatrolRecordsVO> searchList(Map<String,Object> params);

    TPatrolRecordsVO getByRecordId(@Param("id") Long recordId);

    /**
     * 获取巡更点的信息
     * @param pointId
     * @return
     */
    TPatrolRecordsVO getPointInfo(@Param("pointId")Long pointId);


    /**
     * 获取询价项目信息
     * @param pointId
     * @return
     */
    TPatrolRecordsVO getInspectItenmInfo(@Param("pointId")Long pointId);
}
