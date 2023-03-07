package com.huang.service.mybatis;

import com.huang.dto.UserDTO;

public interface LoginServiceMybatis {
    public UserDTO login(String username,String password);
}
