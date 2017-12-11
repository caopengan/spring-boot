package com.example.service.serviceImpl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public List<User> getUserList(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

}
