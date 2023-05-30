package com.soft2242.one.controller;

import com.soft2242.one.common.utils.Result;
import com.soft2242.one.service.AuthService;
import com.soft2242.one.service.service.StorageService;
import com.soft2242.one.vo.AccountLoginVO;
import com.soft2242.one.vo.RepasswordVO;
import com.soft2242.one.vo.SysTokenVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : property-client-api
 * @description : 认证管理
 * @create : 2023-05-23 16:10
 **/

@RestController
@RequestMapping("auth")
@Tag(name = "认证管理")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final StorageService storageService;

    private final

    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    Result<SysTokenVO> login(@RequestBody AccountLoginVO login) {
        SysTokenVO token = authService.loginByAccount(login);
        return Result.ok(token);
    }

    @PostMapping("sendCode")
    @Operation(summary = "发送验证码")
    Result<Void> sendCode(String phone) {
        authService.sendCode(phone);
        return Result.ok();
    }

    @PostMapping("repassword")
    @Operation(summary = "修改密码")
    Result<Void> repassword(@RequestBody RepasswordVO repasswordVO) {
        boolean isOk = authService.repassword(repasswordVO);
        return isOk ? Result.ok() : Result.error("修改密码失败");
    }

    @PostMapping("/file")
    @Operation(summary = "文件上传")
    Result<String> loginByFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String upload = storageService.upload(file.getInputStream(), originalFilename);
        return Result.ok(upload);
    }

}
