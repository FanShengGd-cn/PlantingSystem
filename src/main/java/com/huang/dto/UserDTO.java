package com.huang.dto;

import lombok.Data;

/*
  接受前端请求的参数
 */
@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;


}
