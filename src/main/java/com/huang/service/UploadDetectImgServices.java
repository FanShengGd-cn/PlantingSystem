package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.entity.UploadBlobs;

import java.util.List;

public interface UploadDetectImgServices extends IService<UploadBlobs> {
    public List<UploadBlobs> find();

    public boolean saveBlobs(UploadBlobs blobs);
}
