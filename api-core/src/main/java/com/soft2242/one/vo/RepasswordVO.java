package com.soft2242.one.vo;

import lombok.Data;

/**
 * @author : Ahang
 * @program : property-client-api
 * @description :
 * @create : 2023-05-30 08:34
 **/
@Data
public class RepasswordVO {
    private String phone;
    private String password;
    private String code;
}
