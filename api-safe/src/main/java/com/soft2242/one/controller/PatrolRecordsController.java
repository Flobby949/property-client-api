package com.soft2242.one.controller;


import com.soft2242.one.common.utils.PageResult;
import com.soft2242.one.common.utils.Result;
import com.soft2242.one.convert.PatrolRecordsConvert;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.service.PatrolRecordsService;
import com.soft2242.one.service.service.StorageService;
import com.soft2242.one.vo.FileUploadVO;
import com.soft2242.one.vo.PatrolRecordsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    private final StorageService storageService;
    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<List<PatrolRecordsVO>> page(@ParameterObject @Valid PatrolRecordsQuery query){
//        System.out.println("--------------------------------"+query);

        List<PatrolRecordsVO> page = tPatrolRecordsService.page(query);
//        System.out.println("--------------------------------"+page);
        return Result.ok(page);
    }

    @GetMapping("overPointNumber/{inspectorId}")
    @Operation(summary = "已经巡更点数目")
    public  Result<PatrolRecordsVO> getOverNumber(@PathVariable("inspectorId")Long inspectorId){
        PatrolRecordsVO recordsVOS = tPatrolRecordsService.searchOverNumber(inspectorId);

        return  Result.ok(recordsVOS);
    }



    @GetMapping("noPointNumber/{inspectorId}")

    @Operation(summary = "未巡更点数目")
    public  Result<PatrolRecordsVO> getNoNumber(@PathVariable("inspectorId")Long inspectorId){
        PatrolRecordsVO recordsVOS = tPatrolRecordsService.searchNoNumber(inspectorId);

        return  Result.ok(recordsVOS);
    }

    @GetMapping("allPointNumber/{inspectorId}")
    @Operation(summary = "所有巡更点数目")
    public  Result<PatrolRecordsVO> getAllNumber(@PathVariable("inspectorId")Long inspectorId){

        PatrolRecordsVO recordsVOS = tPatrolRecordsService.searchAllNumber(inspectorId);

        return  Result.ok(recordsVOS);
    }

    @PostMapping("upload")
    @Operation(summary = "项目图片上传")
    public Result<FileUploadVO> upload(@RequestParam("file") MultipartFile file) throws Exception {
//        System.out.println(file);
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        // 上传路径
        String path = storageService.getPath(file.getOriginalFilename());
        // 上传文件
        String url = storageService.upload(file.getBytes(), path);
        FileUploadVO vo = new FileUploadVO();
        vo.setUrl(url);
        vo.setSize(file.getSize());
        vo.setName(file.getOriginalFilename());
        vo.setPlatform(storageService.properties.getConfig().getType().name());

        return Result.ok(vo);
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
        System.out.println("+++++++++++++++++++++++++++++++++"+vo);
        tPatrolRecordsService.update(vo);
        return Result.ok();
    }


}