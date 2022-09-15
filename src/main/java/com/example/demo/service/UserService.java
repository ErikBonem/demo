package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository ur;
    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public User findById(Long id){
        return ur.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return ur.findAll();
    }

    public void createUser(User user){
        ur.save(user);
    }

    public void deleteById(Long id){
        ur.deleteById(id);
    }

//    public void updateUser(Long id){
//        ur.
//    }
}
