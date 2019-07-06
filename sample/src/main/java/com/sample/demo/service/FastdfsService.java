package com.sample.demo.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * date: 2019/7/5
 * description: 完成头像上传相关服务
 */

@Service
public class FastdfsService {

    @Autowired
    DefaultFastFileStorageClient defaultFastFileStorageClient;

    public String upload(InputStream inputStream, String prefix, Long size){
        StorePath path = defaultFastFileStorageClient.uploadFile(inputStream, size, prefix, null);
        return path.getGroup() + '/' + path.getPath();
    }
}
