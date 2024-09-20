package com.GeT.commerce.repositories;

import com.GeT.commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    @Query(value = "SELECT * FROM products WHERE category = ?1", nativeQuery = true)
    List<Product> findByCategory(String category);

    @Query(value = "SELECT DISTINCT category FROM products", nativeQuery = true)
    List<String> findCategories();
}
