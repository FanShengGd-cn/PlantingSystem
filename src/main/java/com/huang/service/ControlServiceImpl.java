package com.huang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.entity.Control;

import com.huang.mapper.ControlMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlServiceImpl extends ServiceImpl<ControlMapper, Control> implements ControlService{

    @Override
    public List<Control> find(){
        return list();
    }

    @Override
    public boolean saveUser(Control control) {
        return saveOrUpdate(control);
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
