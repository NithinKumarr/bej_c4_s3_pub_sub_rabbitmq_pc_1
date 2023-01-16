package com.example.C14_S1_Demo.service;

import com.example.C14_S1_Demo.domain.User;

import java.util.List;

public interface IUserService {
    public User addUser(User product);
    public List<User> getAllUser();
    public User loginCheck(String emailId,String password);
}
