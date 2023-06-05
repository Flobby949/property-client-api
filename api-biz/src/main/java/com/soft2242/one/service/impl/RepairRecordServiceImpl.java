package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.convert.RepairRecordConvert;
import com.soft2242.one.dao.RepairRecordDao;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.service.RepairRecordService;
import com.soft2242.one.vo.RepairRecordVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报修处理表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-06-05
 */
@Service
@AllArgsConstructor
public class RepairRecordServiceImpl extends BaseServiceImpl<RepairRecordDao, RepairRecordEntity> implements RepairRecordService {

    @Override
    public PageResult<RepairRecordVO> page(RepairRecordQuery query) {
        Map<String,Object> parmas=getParams(query);
        IPage<RepairRecordEntity> page = getPage(query);
        parmas.put("page",page);
        List<RepairRecordVO> repairRecordVOS = baseMapper.getRepairRecordList(parmas);
        System.out.println(page.getTotal());
        return new PageResult<>(repairRecordVOS, page.getTotal());
    }


    private Map<String,Object> getParams(RepairRecordQuery query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("employeeIds",query.getEmployeeIds());
        parmas.put("status",query.getStatus());
        return parmas;
    }
    @Override
    public void save(RepairRecordVO vo) {
        RepairRecordEntity entity = RepairRecordConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(RepairRecordVO vo) {
        RepairRecordEntity entity = RepairRecordConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}