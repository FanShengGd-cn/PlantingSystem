package com.huang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.entity.Water;
import com.huang.mapper.WaterSystemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WaterSystemServiceImpl extends ServiceImpl<WaterSystemMapper, Water> implements WaterSystemService {


    @Override
    public List<Water> find() {
        return list();
    }

    @Override
    public boolean saveUser(Water water) {
        return saveOrUpdate(water);
    }

    @Override
    public boolean deleteById(int id) {
        return removeById(id);
    }
    //// 批量删除
    @Override
    public boolean deleteIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
