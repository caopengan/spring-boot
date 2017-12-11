package com.example.service;

import com.example.entity.User;
import com.example.service.serviceImpl.UserServiceImpl;

import java.util.List;

public interface UserService{

    public List<User> getUserList();

}
