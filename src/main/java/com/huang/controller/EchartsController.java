package com.huang.controller;

import cn.hutool.core.collection.CollUtil;
import com.huang.common.Result;
import com.huang.entity.Control;
import com.huang.entity.Feeding;
import com.huang.service.ControlServiceImpl;
import com.huang.service.FeedingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    ControlServiceImpl controlService;

    @GetMapping("/example")
    public Result get(){
        //我们需要一个横轴和纵轴的数据，所以我们可以将数据存放在map里面去
        Map<String,Object> map = new HashMap<>();
        //横轴数据
        map.put("x", CollUtil.newArrayList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        //纵轴数据
        map.put("y",CollUtil.newArrayList(150, 230, 224, 218, 135, 147, 260));

        return Result.success(map);
    }

    @GetMapping("/data")
    public Result data(){
        //查找上料模块的数据
        List<Control> list = controlService.list();



       return Result.success(list);

    }

}
