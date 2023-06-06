package com.soft2242.one.service;



import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.mybatis.service.BaseService;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.vo.OrderDetailVO;
import com.soft2242.one.vo.RepairRecordVO;

import java.util.List;

/**
 * 报修处理表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-06-05
 */
public interface RepairRecordService extends BaseService<RepairRecordEntity> {

    PageResult<RepairRecordVO> page(RepairRecordQuery query);

    void save(RepairRecordVO vo);

    void update(RepairRecordVO vo);

    void delete(List<Long> idList);

    OrderDetailVO getInfo(Long recordId);
}