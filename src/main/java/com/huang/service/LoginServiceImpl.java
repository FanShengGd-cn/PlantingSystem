package com.huang.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.common.Constants;
import com.huang.dto.UserDTO;
import com.huang.entity.User;
import com.huang.exception.ServiceException;
import com.huang.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {
    private static final Log LOG = Log.get();
    @Override
    public UserDTO login(UserDTO userDTO) {
        //数据库查询的话，我们的对象必须要是对应的实体类
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper); //从数据库查询用户信息

       }catch (Exception e){
           LOG.error(e);
           throw new ServiceException(Constants.CODE_500,"系统错误");
       }
        //我们这里要判断这里是否有我要的数据
        if(one !=null){
            //把one里面的数据copy到userDTO里去，不copy的话只有账号密码的信息，copy后有头像昵称的信息
            //忽略大小写
            BeanUtil.copyProperties(one,userDTO,true);
            return userDTO;
        }else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }

    }

    @Override
    public User register(UserDTO userDTO) {
        //校验 注册 账户名不能相同
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());

        User one;
        try {
            one = getOne(queryWrapper);// 从数据库查询用户信息
        }catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        //如果账号不存在，再进行save操作
        if(one ==null){
            //这里如果不new 就 copy会报空指针异常的错误
            one = new User();
            //这里是要把userDTO copy到user里 因为我们存储的是user对象，要把userDTO复制过来然后存储
            BeanUtil.copyProperties(userDTO,one,true);
            save(one); //把copy完的用户对象存储到数据库里
        }else {
            throw new ServiceException(Constants.CODE_600,"用户已存在");
        }
        return one;
    }
}
