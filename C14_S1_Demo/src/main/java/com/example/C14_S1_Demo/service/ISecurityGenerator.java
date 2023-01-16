package com.example.C14_S1_Demo.service;

import com.example.C14_S1_Demo.domain.User;

import java.util.Map;

public interface ISecurityGenerator {
    public Map<String,String> tokenGenerator(User user);
}
