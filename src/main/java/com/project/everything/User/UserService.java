package com.project.everything.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    //Create
    UserEntity registerUser(UserEntity userEntity) throws Exception;
    Map<String, Object> loginUser(Map<String, String> loginInfo) throws Exception;
    //Read
    UserEntity getUserById(String userId) throws Exception;
    //Read
    List<UserEntity> getUserList() throws Exception;
}
