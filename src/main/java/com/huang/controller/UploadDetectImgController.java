package com.huang.controller;

import com.huang.service.SaveImgServices;
import com.huang.service.UploadDetectImgServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadDetectImgController {
//    uploadDetectImg
    @Autowired
    public UploadDetectImgServicesImpl uploadService;

    @Autowired
    public SaveImgServices saveImgServices;

    @PostMapping("/uploadDetectImg")
    public String uploadDetectImg(@RequestBody MultipartFile file) {
        // 调用saveImgServices的保存图片方法，成功则返回新文件名，失败为null
        String newFileName = saveImgServices.saveImg(file);
        // 部署模型进行识别


        //向前端返回识别后base64编码的图片
        byte[] img = null;
        try {
            FileInputStream inputStream = new FileInputStream("file/" + newFileName);
            img = new byte[inputStream.available()];
            inputStream.read(img);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        BASE64Encoder encoder = new BASE64Encoder();
        String base64str = encoder.encode(img);
        return base64str;
    }
}
