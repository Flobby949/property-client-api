package com.soft2242.one.controller;

import com.soft2242.one.common.utils.Result;
import com.soft2242.one.security.user.SecurityUser;
import com.soft2242.one.service.SmartService;
import com.soft2242.one.vo.DoorListItemVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Flobby
 * @program : community-client-api
 * @description : 智慧物联模块接口
 * @create : 2023-05-30 11:44
 **/

@RestController
@RequestMapping("smart")
@AllArgsConstructor
@Tag(name = "智慧物联")
public class SmartController {
    private final SmartService smartService;

    @PostMapping("doorList")
    @Operation(summary = "获取小区门禁列表")
    public Result<List<DoorListItemVO>> getDoorList(@RequestParam Long communityId) {
        return Result.ok(smartService.getDoorList(communityId));
    }

    @PostMapping("openDoor")
    @Operation(summary = "开门")
    public Result<String> openDoor(@RequestParam Long doorId) {
        smartService.openDoor(doorId, SecurityUser.getUserId());
        return Result.ok();
    }
}
