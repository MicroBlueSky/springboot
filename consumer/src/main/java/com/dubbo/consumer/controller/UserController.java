package com.dubbo.consumer.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.dubboapi.model.User;
import com.dubbo.dubboapi.service.UserService;
import com.xiaoleilu.hutool.util.ObjectUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference(version = "1.0", application = "${dubbo.application.id}")
    private UserService userService;

    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello");
        return userService.sayHello();
    }

    @RequestMapping("list")
    public List<User> queryAllUser(){
        List<User> userList = userService.selectAllUser();
        return userList;
    }

    @RequestMapping("add")
    public String createUser(String name, Integer age, String email){
        String msg = "添加失败";
        User user = new User(name,age,email);
        Integer insertCount = userService.insertUser(user);
        if (insertCount == 0){
            return msg;
        }
        msg = "添加成功";
        return msg;
    }

    @RequestMapping("remove")
    public String removeUser(Integer id){
        String msg = "删除失败";
        Integer deleteCount = userService.deleteUserById(id);
        if (deleteCount == 0){
            return msg;
        }
        msg = "删除成功";
        return msg;
    }

    @RequestMapping("update")
    public String updateUser(Integer id, String name, Integer age, String email){
        User user = new User(id,name,age,email);
        String msg = "更新失败";
        Integer updateCount = userService.updateUser(user);
        if(updateCount == 0){
            return msg;
        }
        msg = "更新成功";
        return msg;
    }
}
