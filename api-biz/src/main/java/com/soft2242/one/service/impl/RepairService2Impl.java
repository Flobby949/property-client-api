package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.convert.RepairConvert2;
import com.soft2242.one.dao.RepairDao2;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.query.RepairQuery2;
import com.soft2242.one.service.RepairService;
import com.soft2242.one.service.RepairService2;
import com.soft2242.one.utils.MyUtils;
import com.soft2242.one.vo.RepairVO2;
import com.soft2242.one.vo.RepairVO2;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报修表
 *
 * @author xuelong
 * @since 1.0.0 2023-05-26
 */
@Service
@AllArgsConstructor
public class RepairService2Impl extends BaseServiceImpl<RepairDao2, RepairEntity> implements RepairService2 {

    private final RepairDao2 repairDao;
    @Override
    public PageResult<RepairVO2> page(RepairQuery2 query) {
        Map<String, Object> map = new HashMap<>();
        try {
            map = MyUtils.objectToMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IPage<RepairEntity> page = getPage(query);
        map.put("page", page);
        map.put("communityId", MyUtils.convertToString(query.getCommunityId()));
        List<RepairVO2> list = repairDao.getList(map);
        return new PageResult<>(list, page.getTotal());
    }




    @Override
    public RepairVO2 getById2(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("communityId", id);
        List<RepairVO2> list = repairDao.getList(map);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    private LambdaQueryWrapper<RepairEntity> getWrapper(RepairQuery2 query){
        LambdaQueryWrapper<RepairEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.in(ArrayUtils.isNotEmpty(query.getCommunityId()),RepairEntity::getCommunityId, query.getCommunityId());
        wrapper.like(StringUtils.isNotEmpty(query.getTitle()), RepairEntity::getTitle, query.getTitle());
        wrapper.eq(StringUtils.isNotEmpty(query.getState()) , RepairEntity::getState, query.getState());
        wrapper.eq(StringUtils.isNotEmpty(query.getType()) , RepairEntity::getType, query.getType());
//        wrapper.ge(query.getCreateTime() != null,RepairEntity::getCreateTime, query.getCreateTime());
        wrapper.between(ArrayUtils.isNotEmpty(query.getCreateTime()), RepairEntity::getCreateTime, ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[0] : null, ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[1] : null);
        return wrapper;
    }

    @Override
    public void save(RepairVO2 vo) {
        RepairEntity entity = RepairConvert2.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(RepairVO2 vo) {

        RepairEntity entity = RepairConvert2.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
