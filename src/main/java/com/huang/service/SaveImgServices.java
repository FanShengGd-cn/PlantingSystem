package com.huang.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class SaveImgServices {
    public String saveImg(MultipartFile file) {
//        file.
        if (file.isEmpty()) {
            System.out.println("上传文件为空");
            return null;
        }
        String[] nameSplit = file.getOriginalFilename().split("\\.");
        String newFileName = UUID.randomUUID().toString() + "." + nameSplit[1];
        String fileUploadDir = "file";
        File fileTemp = new File(fileUploadDir + "/" + newFileName);

        //检测目录是否存在
        if(!fileTemp.getParentFile().exists()){
            fileTemp.getParentFile().mkdir();
        }
        //检测文件是否存在
        if(fileTemp.exists()){
            System.out.println("error"+"文件已经存在！");
            return null;
        }
        try{
            FileUtils.writeByteArrayToFile(fileTemp,file.getBytes());
        } catch (IOException e) {
            System.out.println("发生错误："+e);
            return null;
        }
        return newFileName;
    }
}
