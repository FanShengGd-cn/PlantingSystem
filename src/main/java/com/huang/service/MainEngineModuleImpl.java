package com.huang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.entity.Engine;
import com.huang.mapper.MainEngineModuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MainEngineModuleImpl extends ServiceImpl<MainEngineModuleMapper, Engine> implements MainEngineModuleService {


    @Override
    public List<Engine> find() {
//        System.out.println("list为："+list());
        return list();
    }

    @Override
    public boolean saveUser(Engine engine) {
        return saveOrUpdate(engine);
    }

    @Override
    public boolean deleteById(int id) {
        return removeById(id);
    }

    @Override
    public boolean deleteIds(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
