package com.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.dubboapi.model.User;
import com.dubbo.dubboapi.service.UserService;
import com.dubbo.provider.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


//@Service此时不再使用这个注解
@Service(version = "1.0",application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",registry = "${dubbo.registry.id}")
//这个注解时dubbo提供的，其作用是创建此类型的对象，然后作为服务提供者发布
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello() {
        return "Hello world!";
    }

    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<User>();
        userList = userMapper.selectAllUser();
        return userList;
    }

    public Integer insertUser(User user){
        return userMapper.insertUser(user);
    }

    public Integer deleteUserById(Integer id){
        return userMapper.deleteUserById(id);
    }

    public Integer updateUser(User user){
        System.out.println(user.toString());
        return userMapper.updateUser(user);
    }
}
