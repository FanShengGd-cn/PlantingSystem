package com.huang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.entity.Engine;
import com.huang.entity.Feeding;
import com.huang.mapper.FeedingMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedingServiceImpl extends ServiceImpl<FeedingMapper, Feeding> implements FeedingService {
    @Override
    public List<Feeding> find() {
        return list();
    }

    @Override
    public boolean saveUser(Feeding feeding) {
        return saveOrUpdate(feeding);
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean deleteIds(List<Integer> ids) {
        return false;
    }
}
