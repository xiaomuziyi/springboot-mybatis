package com.offcn.controller;


import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public void git(){
        System.out.println("...");
    }

    //添加用户
    @PostMapping("/")
    public String save(User user){
        userService.createUser(user);
        return "success";
    }

    //获取用户
    @GetMapping("/")
    public List<User> getAll(){
        return userService.getUserList();
    }

    //根据id获取用户
    @GetMapping("/{id}")
    public User getByid(@PathVariable(value = "id") Long id){
        return userService.getUser(id);
    }

    //修改用户
    @PutMapping("/{id}")
    public String update(User user,@PathVariable(name = "id")Long id){
        userService.updateUser(id,user);
        return "success";
    }

    //删除用户
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "success";
    }



}
