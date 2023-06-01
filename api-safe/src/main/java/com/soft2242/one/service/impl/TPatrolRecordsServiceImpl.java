package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.convert.TPatrolRecordsConvert;
import com.soft2242.one.dao.TPatrolRecordsDao;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.query.TPatrolRecordsQuey;
import com.soft2242.one.service.TPatrolRecordsService;
import com.soft2242.one.vo.TPatrolRecordsVO;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class TPatrolRecordsServiceImpl extends BaseServiceImpl<TPatrolRecordsDao, PatrolRecordsEntity> implements TPatrolRecordsService {

    @Override
    public PageResult<TPatrolRecordsVO> page(TPatrolRecordsQuey query) {
        Map<String, Object> params = getParams(query);
        IPage<PatrolRecordsEntity> page = getPage(query);
        params.put("page",page);
        List<TPatrolRecordsVO> recordsVOS = baseMapper.searchList(params);
        for (TPatrolRecordsVO vo : recordsVOS){
            if(vo.getType()==0){//如果是巡更点类型
                TPatrolRecordsVO pointInfo = baseMapper.getPointInfo(vo.getPointId());
                vo.setCommunityName(pointInfo.getCommunityName());
                vo.setBuildingName(pointInfo.getBuildingName());
                vo.setUnits(pointInfo.getUnits());
                vo.setPointName(pointInfo.getPointName());
            }
            else {//如果是巡检项目
                TPatrolRecordsVO inspectItenmInfo = baseMapper.getInspectItenmInfo(vo.getPointId());
                vo.setCommunityName(inspectItenmInfo.getCommunityName());
                vo.setPointName(inspectItenmInfo.getPointName());
            }
        }
        return new PageResult<>(recordsVOS, page.getTotal());
    }

    @Override
    public TPatrolRecordsVO getByRecordId(Long recordId) {
        TPatrolRecordsVO vo = baseMapper.getByRecordId(recordId);
        if(vo.getType()==0){//如果是巡更点类型
            TPatrolRecordsVO pointInfo = baseMapper.getPointInfo(vo.getPointId());
            vo.setCommunityName(pointInfo.getCommunityName());
            vo.setBuildingName(pointInfo.getBuildingName());
            vo.setUnits(pointInfo.getUnits());
            vo.setPointName(pointInfo.getPointName());
        }
        else {//如果是巡检项目
            TPatrolRecordsVO inspectItenmInfo = baseMapper.getInspectItenmInfo(vo.getPointId());
            vo.setCommunityName(inspectItenmInfo.getCommunityName());
            vo.setPointName(inspectItenmInfo.getPointName());
        }
        return vo;
    }

    private Map<String,Object> getParams(TPatrolRecordsQuey query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("createTime",query.getPatrolDate());
        parmas.put("inspectorId",query.getInspectorId());
        return parmas;
    }

    @Override
    public void save(TPatrolRecordsVO vo) {
        PatrolRecordsEntity entity = TPatrolRecordsConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(TPatrolRecordsVO vo) {
        PatrolRecordsEntity entity = TPatrolRecordsConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }
}
