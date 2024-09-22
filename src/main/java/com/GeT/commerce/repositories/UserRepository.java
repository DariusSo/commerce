package com.GeT.commerce.repositories;

import com.GeT.commerce.entity.Product;
import com.GeT.commerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, UserDetailsService {

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    public User findByUsername(String username);
}
