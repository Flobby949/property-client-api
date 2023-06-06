package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.convert.RepairConvert;
import com.soft2242.one.dao.RepairDao;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.service.RepairRecordService;
import com.soft2242.one.service.RepairService;
import com.soft2242.one.vo.OrderDetailVO;
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
    private  RepairRecordService repairRecordService;
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


    /**
     * 获取详情信息
     * @param orderId
     * @return
     */
    @Override
    public OrderDetailVO getInfoByOrderId(Long orderId) {
        OrderDetailVO detail = baseMapper.getInfoById(orderId);

        //先查询报修人信息
        if (detail.getUserType()==0) {//身份时业主
            //查询业主信息
            OrderDetailVO userInfo = baseMapper.getUserInfo(detail.getUserId());
            detail.setUsername(userInfo.getUsername());
            detail.setPhone(userInfo.getPhone());
        }
        else {//身份是物业
            //查询物业信息
            OrderDetailVO userInfo = baseMapper.getPropertyInfo(detail.getUserId());
            detail.setUsername(userInfo.getUsername());
            detail.setPhone(userInfo.getPhone());
        }

        /*查询处理人信息*/
        RepairRecordEntity record =baseMapper.getEmployeeIds(detail.getId());
        System.out.println(record);
        if(record!=null){
            String names="";
            String[] strs = record.getEmployeeIds().split(",");
            for (int i = 0; i < strs.length; i++) {
                System.out.println(strs[i]);
                OrderDetailVO propertyInfo = baseMapper.getInfo(Long.valueOf(strs[i]));
                names+= propertyInfo.getUsername()+"  ";
            }
            detail.setHandlerName(names);
            detail.setAllocateTime(record.getCreateTime());
            detail.setResultImgs(record.getImgs());
        }
        detail.setResultName(detail.getHandlerName());
        return detail;
    }

}