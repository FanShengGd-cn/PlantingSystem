package com.huang.controller;

import com.huang.service.SaveImgServices;
import com.huang.service.UploadDetectImgServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadDetectImgController {
//    uploadDetectImg
    @Autowired
    public UploadDetectImgServicesImpl uploadService;

    @Autowired
    public SaveImgServices saveImgServices;

    @PostMapping("/uploadDetectImg")
    public boolean uploadDetectImg(@RequestBody MultipartFile file){
        String newFileName = saveImgServices.checkImg(file);
        System.out.println(newFileName);
        return true;
    }
}
