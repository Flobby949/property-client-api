package com.soft2242.one.service.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.soft2242.one.common.exception.ServerException;
import com.soft2242.one.service.properties.StorageProperties;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 阿里云存储
 *
 * @author Ahang
 */
@Service
public class AliyunStorageService extends StorageService {

    public AliyunStorageService(StorageProperties properties) {
        this.properties = properties;
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        OSS client = new OSSClientBuilder().build(properties.getAliyun().getEndPoint(),
                properties.getAliyun().getAccessKeyId(), properties.getAliyun().getAccessKeySecret());
        try {
            client.putObject(properties.getAliyun().getBucketName(), path, inputStream);
        } catch (Exception e) {
            throw new ServerException("上传文件失败：", e);
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
        return "https://"+properties.getAliyun().getBucketName()+"."+properties.getAliyun().getEndPoint()+"/"+path;
    }

}
