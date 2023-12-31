package com.soft2242.one.dao;

import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import com.soft2242.one.vo.PatrolRecordsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* 巡更记录表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolRecordsDao extends BaseDao<PatrolRecordsEntity> {

    /**
     * 未巡更点数目
     * @param nowDate 今天日期
     * @return
     */
    PatrolRecordsVO searchNoPointNumber(String nowDate,Long inspectorId);

    /**
     * 已经巡更点数目
     * @param nowDate 今天日期
     * @return
     */
    PatrolRecordsVO searchOverPointNumber(String nowDate, Long inspectorId);

    PatrolRecordsVO searchAllPointNumber(String nowDate,Long inspectorId);
    List<PatrolRecordsVO> searchType(Map<String,Object> params);

   PatrolRecordsVO searchNowPointRecord(Long id);
    PatrolRecordsVO searchNowItemRecord(Long id);



}