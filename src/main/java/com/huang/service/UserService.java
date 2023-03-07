package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.entity.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public interface UserService extends IService<User> {
//    public List<User> findAll();
    public List<User> list();

    //保存对象的方法包含新增以及更新的操作，根据ID看情况
//    public int save(User user);
     public boolean saveUser(User user);
    //删除
    public boolean deleteById(@Param("id") int id);

//    //分页查找
//    public List<User> selectPage(int pageNum,int PageSize,String username,String email,String address);
//
//    //查找分页总条数
//    public int selectTotal(String username,String email, String address);


    //批量删除
    public boolean deleteIds(@RequestBody List<Integer> ids);

    //根据姓名查找
    public User findOne(String username);
}
