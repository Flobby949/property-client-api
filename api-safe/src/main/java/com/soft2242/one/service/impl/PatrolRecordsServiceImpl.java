package com.soft2242.one.service.impl;

import com.soft2242.one.common.utils.DateUtils;
import com.soft2242.one.convert.PatrolRecordsConvert;
import com.soft2242.one.dao.PatrolRecordsDao;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.service.PatrolRecordsService;
import com.soft2242.one.vo.PatrolRecordsVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolRecordsServiceImpl extends BaseServiceImpl<PatrolRecordsDao, PatrolRecordsEntity> implements PatrolRecordsService {

    @Override
    public List<PatrolRecordsVO> page(PatrolRecordsQuery query) {
        Map<String, Object> params = getParams(query);
        List<PatrolRecordsVO> recordsVOS = baseMapper.searchType(params);
        List<PatrolRecordsVO> a = new ArrayList<>();

        int i = 0;
        while (i < recordsVOS.size()) {
            if (recordsVOS.get(i).getType() == 0) {
//                System.out.println("--------------------------------------" + recordsVOS.get(i).getId() + recordsVOS.get(i).getType());
                PatrolRecordsVO patrolRecordsVO = baseMapper.searchNowPointRecord(recordsVOS.get(i).getId());
                patrolRecordsVO.setTitle(patrolRecordsVO.getCommunityName()+"-"+patrolRecordsVO.getBuildingName()+"-"+patrolRecordsVO.getUnits()+"单元");
                patrolRecordsVO.setType(0);
                a.add(patrolRecordsVO);


            }
            if (recordsVOS.get(i).getType() == 1) {
                PatrolRecordsVO patrolRecordsVO = baseMapper.searchNowItemRecord(recordsVOS.get(i).getId());
                patrolRecordsVO.setTitle(patrolRecordsVO.getCommunityName()+"-"+patrolRecordsVO.getItemName());
                patrolRecordsVO.setType(1);

                a.add(patrolRecordsVO);
            }
            i++;
        }

        return a;

    }

    private Map<String, Object> getParams(PatrolRecordsQuery query) {
        Map<String, Object> parmas = new HashMap<>();

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(DateUtils.DATE_PATTERN);
        String formatDate = dateFormat.format(date);
        query.setNowDate(formatDate);
        parmas.put("inspectorId", query.getInspectorId());
        parmas.put("nowDate", query.getNowDate());

        return parmas;
    }

    @Override
    public PatrolRecordsVO searchOverNumber(Long inspectorId) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(DateUtils.DATE_PATTERN);
        String formatDate = dateFormat.format(date);

        PatrolRecordsVO recordsVOS = baseMapper.searchOverPointNumber(formatDate,inspectorId);
        return recordsVOS;

    }

    @Override
    public PatrolRecordsVO searchNoNumber(Long inspectorId) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(DateUtils.DATE_PATTERN);
        String formatDate = dateFormat.format(date);

        PatrolRecordsVO recordsVOS = baseMapper.searchNoPointNumber(formatDate,inspectorId);
        return recordsVOS;
    }

    @Override
    public PatrolRecordsVO searchAllNumber(Long inspectorId) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(DateUtils.DATE_PATTERN);
        String formatDate = dateFormat.format(date);

        PatrolRecordsVO recordsVOS = baseMapper.searchAllPointNumber(formatDate,inspectorId);
        return recordsVOS;
    }

    @Override
    public void update(PatrolRecordsVO vo) {
        PatrolRecordsEntity entity = PatrolRecordsConvert.INSTANCE.convert(vo);
        updateById(entity);
    }


}