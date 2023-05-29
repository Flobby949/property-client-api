package com.soft2242.one.service.properties;

import lombok.Data;

@Data
public class MinioStorageProperties {
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}