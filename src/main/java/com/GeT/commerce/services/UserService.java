package com.GeT.commerce.services;

import com.GeT.commerce.entity.User;
import com.GeT.commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private UserRepository userRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository theUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        userRepository = theUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User registerNewUserAccount(User user){

        user.setPassword("{bcrypt}" + bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }


    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username);
    }
}
