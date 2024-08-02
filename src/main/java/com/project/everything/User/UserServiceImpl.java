package com.project.everything.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public UserEntity registerUser(UserEntity userEntity) throws Exception{
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("userData cannot be null or empty");
        }

        //비밀번호 인코딩 후 회원가입
        userEntity.setUserPw(passwordEncoder.encode(userEntity.getUserPw()));

        return userRepository.save(userEntity);
    }

    public Map<String, Object> loginUser(Map<String, String> loginInfo) throws Exception{
        if (loginInfo.isEmpty()) {
            throw new IllegalArgumentException("userData cannot be null or empty");
        }

        var userId = loginInfo.get("userId");
        var userPw = loginInfo.get("userPw");

        //userId로 db에 해당 user가 존재하는지 확인
        UserEntity dbUserEntity = userRepository.getUserById(userId);
        if (dbUserEntity.isEmpty()) {
            throw new IllegalArgumentException("userData cannot be null or empty");
        }

        Map<String, Object> loginResult = new HashMap<String, Object>();
        //userPw로 db에 저장된 인코딩된 비밀번호와 매치하는지 확인
        if(passwordEncoder.matches(userPw, dbUserEntity.getUserPw())){
            loginResult.put("userInfo", dbUserEntity);
            loginResult.put("login", true);

        }else{
            loginResult.put("login", false);
        }

        return loginResult;
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
