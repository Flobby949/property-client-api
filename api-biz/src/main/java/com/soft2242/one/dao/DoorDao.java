package com.soft2242.one.dao;

import com.soft2242.one.entity.DoorEntity;
import com.soft2242.one.mybatis.dao.BaseDao;
import com.soft2242.one.vo.DoorListItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
* 门禁管理
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface DoorDao extends BaseDao<DoorEntity> {

    List<DoorListItemVO> selectDoor(Long communityId);
}