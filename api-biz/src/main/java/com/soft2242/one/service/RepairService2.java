package com.soft2242.one.service;


import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.mybatis.service.BaseService;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.query.RepairQuery2;
import com.soft2242.one.vo.RepairVO;
import com.soft2242.one.vo.RepairVO2;

import java.util.List;

/**
 * 报修表
 *
 * @author xuelong
 * @since 1.0.0 2023-05-26
 */
public interface RepairService2 extends BaseService<RepairEntity> {

    PageResult<RepairVO2> page(RepairQuery2 query);

    RepairVO2 getById2(String id);

    void save(RepairVO2 vo);

    void update(RepairVO2 vo);

    void delete(List<Long> idList);
}
