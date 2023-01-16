package com.example.C14_S1_Demo.service;

import com.example.C14_S1_Demo.domain.User;
import com.example.C14_S1_Demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    IUserRepository userRepository;
    public UserService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User addUser(User user) {
        if (userRepository.findById(user.getEmailId()).isEmpty()) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User loginCheck(String emailId, String password) {
        if(userRepository.findById(emailId).isPresent()){
            User user=userRepository.findById(emailId).get();
            if(user.getPassword().equals(password)){
                return user;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
}
