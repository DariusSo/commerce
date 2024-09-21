package com.GeT.commerce.repositories;

import com.GeT.commerce.entity.Product;
import com.GeT.commerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
