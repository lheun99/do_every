package com.project.everything.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserEntity saveUser(UserEntity userEntity) throws Exception{
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("userData cannot be null or empty");
        }

        //비밀번호 인코딩 후 회원가입
        userEntity.setUserPw(passwordEncoder.encode(userEntity.getUserPw()));

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
