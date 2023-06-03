package com.soft2242.one.controller;

import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.common.utils.Result;
import com.soft2242.one.convert.PatrolRecordsConvert;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.query.TPatrolRecordsQuey;
import com.soft2242.one.service.PatrolRecordsService;
import com.soft2242.one.service.TPatrolRecordsService;
import com.soft2242.one.vo.PatrolRecordsVO;
import com.soft2242.one.vo.TPatrolRecordsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@RestController
@RequestMapping("safe/record2")
@Tag(name="巡更记录2")
@AllArgsConstructor
public class TPatrolRecordsController {
    private final TPatrolRecordsService tPatrolRecordsService;

    @GetMapping("page")
    @Operation(summary = "分页")
//   @PreAuthorize("hasAuthority('soft2242:records:page')")
    public Result<PageResult<TPatrolRecordsVO>> page(@ParameterObject @Valid TPatrolRecordsQuey query){
        PageResult<TPatrolRecordsVO> page = tPatrolRecordsService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:records:info')")
    public Result<TPatrolRecordsVO> get(@PathVariable("id") Long id){
        TPatrolRecordsVO vo= tPatrolRecordsService.getByRecordId(id);

        return Result.ok(vo);
    }


    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:records:update')")
    public Result<String> update(@RequestBody @Valid TPatrolRecordsVO vo){
        tPatrolRecordsService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:records:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tPatrolRecordsService.delete(idList);

        return Result.ok();
    }
}
