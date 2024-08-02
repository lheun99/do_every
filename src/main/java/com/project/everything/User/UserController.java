package com.project.everything.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/user")

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //Create
    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity userEntity) throws Exception {
        return userService.registerUser(userEntity);
    }
    @PostMapping("/login")
    public Map<String, Object> loginUser(@RequestBody Map<String, String> loginInfo) throws Exception {
        return userService.loginUser(loginInfo);
    }

    //Read
    @GetMapping("/id/{userId}")
    public UserEntity getUserById(@PathVariable("userId") String userId) throws Exception {
        // id 값을 사용하여 사용자 정보를 조회하는 로직을 추가합니다.
        return userService.getUserById(userId);
    }

    @GetMapping("/list")
    public List<UserEntity> getUserList() throws Exception {
        return userService.getUserList();
    }

}
