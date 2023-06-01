package com.soft2242.one.controller;


import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.common.utils.Result;
import com.soft2242.one.convert.PatrolRecordsConvert;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.service.PatrolRecordsService;
import com.soft2242.one.vo.PatrolRecordsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 巡更记录表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("safe/record")
@Tag(name="巡更记录")
@AllArgsConstructor
public class PatrolRecordsController {
    private final PatrolRecordsService tPatrolRecordsService;

    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<List<PatrolRecordsVO>> page(@ParameterObject @Valid PatrolRecordsQuery query){
        System.out.println("--------------------------------"+query);

        List<PatrolRecordsVO> page = tPatrolRecordsService.page(query);
        System.out.println("--------------------------------"+page);
        return Result.ok(page);
    }

    @GetMapping("overPointNumber")
    @Operation(summary = "已经巡更点数目")
    public  Result<PatrolRecordsVO> getOverNumber(){
        PatrolRecordsVO recordsVOS = tPatrolRecordsService.searchOverNumber();

        return  Result.ok(recordsVOS);
    }


    @GetMapping("noPointNumber")
    @Operation(summary = "未巡更点数目")
    public  Result<PatrolRecordsVO> getNoNumber(){
        PatrolRecordsVO recordsVOS = tPatrolRecordsService.searchNoNumber();

        return  Result.ok(recordsVOS);
    }

    @GetMapping("allPointNumber")
    @Operation(summary = "所有巡更点数目")
    public  Result<PatrolRecordsVO> getAllNumber(){

        PatrolRecordsVO recordsVOS = tPatrolRecordsService.searchAllNumber();

        return  Result.ok(recordsVOS);
    }





//    @GetMapping("{id}")
//    @Operation(summary = "信息")
////    @PreAuthorize("hasAuthority('soft2242:records:info')")
//    public Result<PatrolRecordsVO> get(@PathVariable("id") Long id){
//        PatrolRecordsEntity entity = tPatrolRecordsService.getById(id);
//
//        return Result.ok(PatrolRecordsConvert.INSTANCE.convert(entity));
//    }



    @PutMapping
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid PatrolRecordsVO vo){
        tPatrolRecordsService.update(vo);
        return Result.ok();
    }


}