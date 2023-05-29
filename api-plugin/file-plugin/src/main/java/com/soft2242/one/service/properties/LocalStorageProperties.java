package com.soft2242.one.service.properties;

import lombok.Data;

@Data
public class LocalStorageProperties {
    /**
     * 本地存储路径
     */
    private String path;
    /**
     * 资源起始路径
     */
    private String url = "upload";
}