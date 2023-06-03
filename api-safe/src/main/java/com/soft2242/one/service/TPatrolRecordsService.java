package com.soft2242.one.service;

import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.mybatis.service.BaseService;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.query.TPatrolRecordsQuey;
import com.soft2242.one.vo.PatrolRecordsVO;
import com.soft2242.one.vo.TPatrolRecordsVO;

import java.util.List;

/**
 * 巡更记录表
 *
 * @author litao
 * @since 1.0.0 2023-05-25
 */
public interface TPatrolRecordsService extends BaseService<PatrolRecordsEntity> {
    PageResult<TPatrolRecordsVO> page(TPatrolRecordsQuey query);

    TPatrolRecordsVO getByRecordId(Long recordId);

    void save(TPatrolRecordsVO vo);

    void update(TPatrolRecordsVO vo);

    void delete(List<Long> idList);
}
