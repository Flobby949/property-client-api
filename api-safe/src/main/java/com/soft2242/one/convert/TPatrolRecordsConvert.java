package com.soft2242.one.convert;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.vo.PatrolRecordsVO;

import com.soft2242.one.vo.TPatrolRecordsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Mapper
public interface TPatrolRecordsConvert {
    TPatrolRecordsConvert INSTANCE = Mappers.getMapper(TPatrolRecordsConvert.class);

    PatrolRecordsEntity convert(TPatrolRecordsVO vo);

    TPatrolRecordsVO convert(PatrolRecordsEntity entity);

    List<TPatrolRecordsVO> convertList(List<PatrolRecordsEntity> list);
}
