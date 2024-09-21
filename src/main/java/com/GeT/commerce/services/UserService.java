package com.GeT.commerce.services;

import com.GeT.commerce.entity.User;
import com.GeT.commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User registerNewUserAccount(User user){

        user.setPassword("{bcrypt}" + bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }
}
