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
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.service.RepairService;
import com.soft2242.one.vo.RepairVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> parmas=getParams(query);
        IPage<RepairEntity> page = getPage(query);
        parmas.put("page",page);
        List<RepairEntity> lists = baseMapper.getLists(parmas);
        return new PageResult<>(RepairConvert.INSTANCE.convertList(lists), page.getTotal());
    }

    private Map<String,Object> getParams(RepairQuery query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("type",query.getType());
        parmas.put("state",query.getState());
        return parmas;
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