package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.entity.Control;
import com.huang.entity.Water;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface WaterSystemService extends IService<Water> {
    //查找全部数据
    public List<Water> find();


    //保存对象，包含更新和新增
    public boolean saveUser(Water water);

    //删除
    public boolean deleteById(@Param("id") int id);

    //批量删除
    public boolean deleteIds(@RequestBody List<Integer> ids);
}
