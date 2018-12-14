package com.dubbo.dubboapi.service;

import com.dubbo.dubboapi.model.User;

import java.util.List;

public interface UserService {
    String sayHello();

    List<User> selectAllUser();

    Integer insertUser(User user);

    Integer deleteUserById(Integer id);

    Integer updateUser(User user);

}
