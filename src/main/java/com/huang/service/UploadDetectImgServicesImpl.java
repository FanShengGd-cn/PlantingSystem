package com.huang.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.entity.UploadBlobs;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class UploadDetectImgServicesImpl implements UploadDetectImgServices{
    @Override
    public List<UploadBlobs> find() {
        return list();
    }

    @Override
    public boolean saveBlobs(UploadBlobs blobs) {
        return saveOrUpdate(blobs);
    }


    public boolean saveBatch(Collection<UploadBlobs> entityList, int batchSize) {
        return false;
    }

    public boolean saveOrUpdateBatch(Collection<UploadBlobs> entityList, int batchSize) {
        return false;
    }

    public boolean updateBatchById(Collection<UploadBlobs> entityList, int batchSize) {
        return false;
    }

    public boolean saveOrUpdate(UploadBlobs entity) {
        return false;
    }

    public UploadBlobs getOne(Wrapper<UploadBlobs> queryWrapper, boolean throwEx) {
        return null;
    }

    public Map<String, Object> getMap(Wrapper<UploadBlobs> queryWrapper) {
        return null;
    }

    public <V> V getObj(Wrapper<UploadBlobs> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    public BaseMapper<UploadBlobs> getBaseMapper() {
        return null;
    }

    public Class<UploadBlobs> getEntityClass() {
        return null;
    }
}
