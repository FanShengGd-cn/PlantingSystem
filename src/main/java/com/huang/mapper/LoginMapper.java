package com.huang.mapper;

import com.huang.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    public UserDTO login(String username,String password);
}
