package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.convert.RepairRecordConvert;
import com.soft2242.one.dao.RepairDao;
import com.soft2242.one.dao.RepairRecordDao;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.service.RepairRecordService;
import com.soft2242.one.service.RepairService;
import com.soft2242.one.vo.OrderDetailVO;
import com.soft2242.one.vo.RepairRecordVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 报修处理表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-06-05
 */
@Service
@AllArgsConstructor
public class RepairRecordServiceImpl extends BaseServiceImpl<RepairRecordDao, RepairRecordEntity> implements RepairRecordService {
        private final RepairDao repairDao;
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
        RepairEntity entity1 = repairDao.selectById(entity.getRepairId());
        entity1.setResult(entity.getResult());
        Date date=new Date();
        entity1.setHandleTime(date);
        entity1.setState(entity.getState());
        int i = repairDao.updateById(entity1);
        updateById(entity);
        System.out.println("==================="+i);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public OrderDetailVO getInfo(Long recordId) {
        //先查询记录
        RepairRecordEntity entity = getById(recordId);
        //通过报修记录找到报修
        OrderDetailVO detail = repairDao.getInfoById(entity.getRepairId());
        if (detail.getUserType()==0) {//身份时业主
            //查询业主信息
            OrderDetailVO userInfo = repairDao.getUserInfo(detail.getUserId());
            detail.setUsername(userInfo.getUsername());
            detail.setPhone(userInfo.getPhone());
        }
        else {//身份是物业
            //查询物业信息
            OrderDetailVO userInfo = repairDao.getPropertyInfo(detail.getUserId());
            detail.setUsername(userInfo.getUsername());
            detail.setPhone(userInfo.getPhone());
        }
        return detail;
    }

}