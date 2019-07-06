package com.sample.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * date: 2019/6/25
 * description: 文件上传工具类
 */

public class FileUtils {

    public static String path = "C:\\Users\\Administrator\\Desktop\\IDEA\\sample\\src\\main\\resources\\static\\headport";

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getFileName(String fileOriginName){
        return getUUID() + getSuffix(fileOriginName);
    }

    public static boolean upload(MultipartFile file, String fileName){

        String realPath = path + "\\" + fileName;
        System.out.println(realPath);
        File dest = new File(realPath);

        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}