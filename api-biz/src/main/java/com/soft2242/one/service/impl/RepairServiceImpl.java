package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.convert.RepairConvert;
import com.soft2242.one.dao.RepairDao;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.service.RepairService;
import com.soft2242.one.vo.RepairVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 报修表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-06-05
 */
@Service
@AllArgsConstructor
public class RepairServiceImpl extends BaseServiceImpl<RepairDao, RepairEntity> implements RepairService {

    @Override
    public PageResult<RepairVO> page(RepairQuery query) {
        IPage<RepairEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(RepairConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<RepairEntity> getWrapper(RepairQuery query){
        LambdaQueryWrapper<RepairEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNotEmpty(String.valueOf(query.getType())), RepairEntity::getType, query.getType());
        wrapper.eq(StringUtils.isNotEmpty(String.valueOf(query.getState())), RepairEntity::getState, query.getState());
        return wrapper;
    }

    @Override
    public void save(RepairVO vo) {
        RepairEntity entity = RepairConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(RepairVO vo) {
        RepairEntity entity = RepairConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}