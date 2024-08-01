package com.project.everything.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Create
    @Override
    public UserEntity saveUser(UserEntity userEntity) throws Exception{
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("userData cannot be null or empty");
        }

        return userRepository.save(userEntity);
    }

    //Read
    @Override
    public UserEntity getUserById(String userId){
        return userRepository.getUserById(userId);
    }
    //Read
    @Override
    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }
}
