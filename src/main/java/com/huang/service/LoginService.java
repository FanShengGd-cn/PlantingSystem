package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.dto.UserDTO;
import com.huang.entity.User;

public interface LoginService extends IService<User> {
    public UserDTO login(UserDTO userDTO);


    public User register(UserDTO userDTO);
}
