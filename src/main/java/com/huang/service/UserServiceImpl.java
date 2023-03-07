package com.huang.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.entity.User;
import com.huang.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService   {
//    @Autowired
//    UserMapper userMapper;

    @Override
    public List<User> list() {

//        return userMapper.findAll();
        return list();
    }

    //新增以及修改用户的操作
//    @Override
//    public int save( User user) {
//        //因为设置的是interger类型，所以可以跟null判断
//        //user没有iD的话就是表示这是新增了
//        if(user.getId()==null){
//          return   userMapper.add(user);
//        }else { //有ID就算更新
//          return   userMapper.update(user);
//        }
//
//    }

    @Override
    public boolean saveUser(User user){
//        if(user.getId()==null){
//            //自动写了新增插入
//           boolean save = save(user); //mybatis提供的方法，表示插入数据
//            return save;
//        }else {
//            return updateById(user);//更新成功返回true 不然 false
//        }
        return saveOrUpdate(user);
    }




    //按ID删除
    @Override
//    public int deleteById(@Param("id") int id) {
//        return userMapper.deleteById(id);
//    }
    public boolean deleteById(@Param("id") int id){
        return removeById(id);
    }


//    //分页
//    @Override
//    public List<User> selectPage(int pageNum, int pageSize,String username,String email,String address) {
//        //前端首先拿到一个我们需要进入的页面，比如要进第三页，但实际上数据库拿到是需要对接受的页码参数进行处理，需要减-1乘上每页显示的行数才是我们真正的pageNum
//        pageNum=(pageNum-1)*pageSize;
//        return userMapper.selectPage(pageNum, pageSize,username,email,address);
//    }
//
//    //查询分页的总条数
//
//    @Override
//    public int selectTotal(String username,String email,String address) {
//
//
//        return userMapper.selectTotal(username,email,address);
//    }

   // 批量删除
    @Override
    public boolean deleteIds(@RequestBody List<Integer> ids) {
        return removeBatchByIds(ids);

    }
   //根据姓名查找
    @Override
    public User findOne(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("username",username);
        return getOne(queryWrapper);
    }
}
