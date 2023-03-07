package com.huang.common;

import lombok.Data;
/*
接口统一返回包装类
 */
@Data
public class Result {
    //约定一个code 来代表成功或者失败
    private String code;
    //请求失败的原因，后端告诉前端
    private String msg;
    //后台所需要的数据
    private Object data;

    public Result() {
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

//这是没有数据的成功
    public static Result success(){
        return new Result(Constants.CODE_200,"",null);
    }

    //有数据的成功
    public static Result success(Object data){
        return new Result(Constants.CODE_200,"",data);
    }
    //error 自定义状态码 因为是错误所以也不需要返回数据给前端
    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }
    //默认一个系统错误error500
    public static Result error(){
        return new Result(Constants.CODE_500,"系统错误",null);
    }
}
