package com.soft2242.one.convert;

import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.vo.RepairVO;
import com.soft2242.one.vo.RepairVO2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 报修表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-26
 */
@Mapper(uses = {MyMapper.class})
public interface RepairConvert2 {

    RepairConvert2 INSTANCE = Mappers.getMapper(RepairConvert2.class);

    @Mapping(target = "employeeIds", source = "employeeIds", qualifiedByName = "convertToString")
    @Mapping(target = "imgs", source = "imgs", qualifiedByName = "convertToString")
    RepairEntity convert(RepairVO2 vo);

//    @Mapping(target = "employeeIds", source = "employeeIds", qualifiedByName = "convertToArray")
//    @Mapping(target = "imgs", source = "imgs", qualifiedByName = "convertToArray")
//    RepairVO convert(RepairEntity entity);
//
//    @Mapping(target = "employeeIds", source = "employeeIds", qualifiedByName = "convertToArray")
//    @Mapping(target = "imgs", source = "imgs", qualifiedByName = "convertToArray")
//    List<RepairVO2> convertList(List<RepairEntity> list);


}
