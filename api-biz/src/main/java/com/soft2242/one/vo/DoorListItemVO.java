package com.soft2242.one.vo;

import lombok.Data;

/**
 * @author : Flobby
 * @program : community-client-api
 * @description : 门禁列表VO
 * @create : 2023-05-30 11:47
 **/

@Data
public class DoorListItemVO {
    private Integer doorId;
    private String doorName;
    private String doorImg;
    private Integer onlineStatus;
    /**
     * 设备状态（0：正常 1：故障）
     */
    private Integer deviceStatus;
    private String deviceName;
    private String deviceType;
}
