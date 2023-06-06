package com.soft2242.one.controller;

import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.common.utils.Result;
import com.soft2242.one.convert.RepairRecordConvert;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.service.RepairRecordService;
import com.soft2242.one.vo.OrderDetailVO;
import com.soft2242.one.vo.RepairRecordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 报修处理表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-06-05
*/
@RestController
@RequestMapping("repair/record")
@Tag(name="报修处理表")
@AllArgsConstructor
public class RepairRecordController {
    private final RepairRecordService RepairRecordService;

    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<PageResult<RepairRecordVO>> page(@ParameterObject @Valid RepairRecordQuery query){
        PageResult<RepairRecordVO> page = RepairRecordService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<OrderDetailVO> get(@PathVariable("id") Long id){
        return Result.ok(RepairRecordService.getInfo(id));
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody RepairRecordVO vo){
        RepairRecordService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid RepairRecordVO vo){
        RepairRecordService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result<String> delete(@RequestBody List<Long> idList){
        RepairRecordService.delete(idList);
        return Result.ok();
    }
}