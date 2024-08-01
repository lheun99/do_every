package com.project.everything.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //Create
    UserEntity saveUser(UserEntity userEntity) throws Exception;

    //Read
    UserEntity getUserById(String userId) throws Exception;
    //Read
    List<UserEntity> getUserList() throws Exception;
}
