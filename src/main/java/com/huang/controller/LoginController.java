package com.huang.controller;

import cn.hutool.core.util.StrUtil;
import com.huang.common.Constants;
import com.huang.common.Result;
import com.huang.dto.UserDTO;
import com.huang.service.LoginServiceImpl;
import com.huang.service.mybatis.LoginServiceImplMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
    @Autowired
    LoginServiceImpl loginService;

    //接受前端传输过来的账号密码并对其进行验证
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        //判断账户密码是否为空
        if(StrUtil.isBlank(username)||StrUtil.isBlank(password)){
            return  Result.error(Constants.CODE_400,"参数不足错误");
        }

        UserDTO dto = loginService.login(userDTO);
        return Result.success(dto);
    }
    //注册
    @PostMapping("/register")
    //注册的接口
    public Result register(@RequestBody UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        //判断账户密码是否为空
        if(StrUtil.isBlank(username)||StrUtil.isBlank(password)){
            return  Result.error(Constants.CODE_400,"参数不足错误");
        }
        return Result.success(loginService.register(userDTO));
    }



//    @Autowired
//    LoginServiceImplMybatis loginServiceMybatis;
//    @PostMapping("/login")
//    public UserDTO Login(@RequestBody UserDTO userDTO){
//
//        String username = userDTO.getUsername();
//        String password = userDTO.getPassword();
////        判断账户密码是否为空
//        if(StrUtil.isBlank(username)||StrUtil.isBlank(password)){
//            return null;
//        }else {
//            return loginServiceMybatis.login(username,password);
//        }
//
//    }

}
