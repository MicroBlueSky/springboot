package com.dubbo.provider.dao;

import com.dubbo.dubboapi.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAllUser();

    Integer insertUser(User user);

    Integer deleteUserById(Integer id);

    Integer updateUser(User user);
}
