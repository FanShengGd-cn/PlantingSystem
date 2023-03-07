package com.huang.exception;

import lombok.Getter;

/*
自定义异常
 */
//继承下运行时的异常
@Getter
public class ServiceException extends RuntimeException {
    private String code;
     //提供了一个ServiceException的构造函数
    public ServiceException(String code,String msg){
        super(msg);
        this.code =code;
    }
}
