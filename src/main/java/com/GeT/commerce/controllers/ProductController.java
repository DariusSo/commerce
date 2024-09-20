package com.GeT.commerce.controllers;

import com.GeT.commerce.entity.Product;
import com.GeT.commerce.exceptions.ErrorResponse;
import com.GeT.commerce.exceptions.ProductNotFoundException;
import com.GeT.commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){

        Product product = productService.findById(id);
        if(product == null){
            throw new ProductNotFoundException("Product with id '" + id + "' not found");
        }

        return product;
    }

    @CrossOrigin
    @PutMapping
    public void save(@RequestBody Product product, int id){
        productService.save(product, id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteById(id);
    }

    @CrossOrigin
    @GetMapping("/category/{category}")
    public List<Product> findByCategory(@PathVariable String category){
        return productService.findByCategory(category);
    }

    @CrossOrigin
    @GetMapping("/categories/get")
    public List<String> findCategories(){
        return productService.findCategories();
    }
}
