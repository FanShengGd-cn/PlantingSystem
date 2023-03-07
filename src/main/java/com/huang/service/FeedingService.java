package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.entity.Engine;
import com.huang.entity.Feeding;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FeedingService extends IService<Feeding> {
    //查找全部数据
    public List<Feeding> find();


    //保存对象，包含更新和新增
    public boolean saveUser(Feeding engine);

    //删除
    public boolean deleteById(@Param("id") int id);

    //批量删除
    public boolean deleteIds(@RequestBody List<Integer> ids);
}
