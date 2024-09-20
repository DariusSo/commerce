package com.GeT.commerce.services;

import com.GeT.commerce.entity.Product;
import com.GeT.commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository theProductRepository) {
        productRepository = theProductRepository;
    }

    public Product save(Product product, int id) {
        //check if product is found
        Product product1 = productRepository.findById(id);
        //then
        product.setId(id);
        return productRepository.save(product);
    }

    public Product findById(int id){
        Optional<Product> result = Optional.ofNullable(productRepository.findById(id));
        Product product = null;
        if(result.isPresent()){
            product = result.get();
        }
        return product;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(int id){
        productRepository.deleteById(id);
    }
    public List<Product> findByCategory(String category){
        return productRepository.findByCategory(category);
    }
    public List<String> findCategories(){
        return productRepository.findCategories();
    }
}
