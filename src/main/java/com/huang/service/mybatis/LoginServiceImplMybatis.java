package com.huang.service.mybatis;

import com.huang.dto.UserDTO;
import com.huang.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplMybatis implements LoginServiceMybatis {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public UserDTO login(String username, String password) {
        UserDTO userDTO = loginMapper.login(username, password);
        return userDTO;
    }
}
