package com.project.everything.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //Create
    @PostMapping("/save")
    public UserEntity saveUser(@RequestBody UserEntity userEntity) throws Exception {
        return userService.saveUser(userEntity);
    }

    //Read
    @GetMapping("/id/{userId}")
    public UserEntity getUserById(@PathVariable("userId") String userId) throws Exception {
        // id 값을 사용하여 사용자 정보를 조회하는 로직을 추가합니다.
        System.out.println("------------------------");
        System.out.println(userId);
        return userService.getUserById(userId);
    }

    @GetMapping("/list")
    public List<UserEntity> getUserList() throws Exception {
        return userService.getUserList();
    }
}
