package com.huang.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "upload_blobs")
public class UploadBlobs {
    private int id;
    private byte[] blobs;
}
