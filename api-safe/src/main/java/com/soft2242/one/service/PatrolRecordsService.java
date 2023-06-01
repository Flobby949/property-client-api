package com.soft2242.one.service;


import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.mybatis.service.BaseService;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.vo.PatrolRecordsVO;

import java.util.List;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface PatrolRecordsService extends BaseService<PatrolRecordsEntity> {

    List<PatrolRecordsVO> page(PatrolRecordsQuery query);

    PatrolRecordsVO searchOverNumber();

    PatrolRecordsVO searchNoNumber();

    PatrolRecordsVO searchAllNumber();

    void update(PatrolRecordsVO vo);





}