package com.huang;

import com.huang.entity.Control;
import com.huang.entity.Feeding;
import com.huang.entity.User;
import com.huang.service.ControlService;
import com.huang.service.ControlServiceImpl;
import com.huang.service.FeedingServiceImpl;
import com.huang.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ControlService controlService;

    @Autowired
    FeedingServiceImpl feedingService;

    @Test
    void contextLoads() {
//        List<User> user =userService.findAll();
//        System.out.println(user);
    }

    @Test
    void contextLoads2() {
        List<Feeding> list = feedingService.list();
        System.out.println(list);
        // mybatis-plus 默认是开启驼峰映射的
        // 比如 induced_draft_fan_start_manually 这样的话，mybatis-plus 会映射为 inducedDraftFanStartManually
        // 如果不开启的话，默认是 induced_draft_fan_start_manually 映射为 induced_draft_fan_start_manually
        // inducedDraftFanStartManually 是对象的字段名称，induced_draft_fan_start_manually是数据库的字段
    }
}
