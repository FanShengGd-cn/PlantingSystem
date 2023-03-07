package com.huang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huang.common.Result;
import com.huang.entity.User;
import com.huang.mapper.UserMapper;
import com.huang.service.UserServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/")
    //查找所有用户
    public List<User> findAll(){
        return userService.list();
    }
    //RequestBody是可以将前端的json转为后端java对象的
    @PostMapping
   // 这个方法现在就包含了更新和新增的操作
    public boolean save(@RequestBody User user){
//        return userService.save(user);
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    //pathvariable后面指定的id跟mapping请求里的id需要一致,他是获取路径里的参数的，也就是指/这种下面的参数
    public boolean  delete(@PathVariable int id){
       return userService.deleteById(id);
    }

    //批量删除
    @PostMapping("/del/batch")
    //因为我们要批量传入ID了，需要用到requestBody
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.deleteIds(ids);
    }

    //分页查询接口
    //接口路径：/user/page
    //@RequestParam接受 ?pageNum=1&pageSize=10映射到下方来
    //结论：limit 第一个的参数=（pageNum-1)*pageSize
    //第二个参数就是pagesize
//    @GetMapping("/page") //接口路径：/user/page
//    public Map<String,Object> findPage(@RequestParam int pageNum,
//                                       @RequestParam int pageSize,
//                                       @RequestParam String username,
//                                       @RequestParam String email,
//                                       @RequestParam String address) {
//
//        //前端首先拿到一个我们需要进入的页面，比如要进第三页，但实际上数据库拿到是需要对接受的页码参数进行处理，需要减-1乘上每页显示的行数才是我们真正的pageNum
////        这个应该放在servce层进行处理，controller直接调用
////        pageNum=(pageNum-1)*pageSize;
//        //需要显示一共查找了多少数据
//        int total = userService.selectTotal(username,email,address);
//        List<User> users = userService.selectPage(pageNum, pageSize,username,email,address);
//        //我们拿一个数组同时存放数据条数以及我们查找的人员数据的信息
//        Map<String, Object> res = new HashMap<>();
//        res.put("data", users);
//        res.put("total", total);
//        return res;
//
//
//    }
    @GetMapping("/page") //接口路径：/user/page
    public IPage<User> findPage(@RequestParam int pageNum,
                                @RequestParam int pageSize,
                                @RequestParam(defaultValue ="")  String username,
                                @RequestParam(defaultValue ="") String email,
                                @RequestParam (defaultValue ="")String address) {

        //前端首先拿到一个我们需要进入的页面，比如要进第三页，但实际上数据库拿到是需要对接受的页码参数进行处理，需要减-1乘上每页显示的行数才是我们真正的pageNum
//        这个应该放在servce层进行处理，controller直接调用
//        pageNum=(pageNum-1)*pageSize;
        //需要显示一共查找了多少数据
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //引号里的是数据库字段名
        if(!"".equals(username)){
            queryWrapper.like("username", username);
        }
        if(!"".equals(email)){
            queryWrapper.like("email", email);
        }
        if(!"".equals(address)){
            queryWrapper.like("address", address);
        }


        IPage<User> userIPage = userService.page(page, queryWrapper);
        return userIPage;
    }

    //显示个人信息
    @GetMapping("/username/{username}")
    public Result findOne(@PathVariable String username){


        return Result.success(userService.findOne(username));



    }



}
