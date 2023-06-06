package com.soft2242.one.controller;

import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.common.utils.Result;
import com.soft2242.one.convert.RepairConvert;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.service.RepairService;
import com.soft2242.one.vo.RepairVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 报修表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-06-05
*/
@RestController
@RequestMapping("repair/repair")
@Tag(name="报修表")
@AllArgsConstructor
public class RepairController {
    private final RepairService RepairService;

    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<PageResult<RepairVO>> page(@ParameterObject @Valid RepairQuery query){
        PageResult<RepairVO> page = RepairService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<RepairVO> get(@PathVariable("id") Long id){
        RepairEntity entity = RepairService.getById(id);

        return Result.ok(RepairConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody RepairVO vo){
        RepairService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid RepairVO vo){
        RepairService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result<String> delete(@RequestBody List<Long> idList){
        RepairService.delete(idList);
        return Result.ok();
    }
}