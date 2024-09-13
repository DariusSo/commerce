package com.GeT.commerce.controllers;

import com.GeT.commerce.entity.Product;
import com.GeT.commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){
        return productService.findById(id);
    }
    @PutMapping
    public void save(@RequestBody Product product, int id){
        productService.save(product, id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteById(id);
    }

}
