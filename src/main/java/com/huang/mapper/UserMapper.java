package com.huang.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

//查找所有人
    public List<User> findAll();

    //添加用户
    public int  add(User user);


    //更新用户
    public int update(User user);

    //删除用户
    public int deleteById(@Param("id") int id);

//    //根据页面查找显示
//    public List<User> selectPage(int pageNum,int pageSize,String username,String email,String address);

    //查询页面的数据总数
    public int selectTotal(String username,String email,String address);
}
