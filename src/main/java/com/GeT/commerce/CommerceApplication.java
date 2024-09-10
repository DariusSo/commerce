package com.GeT.commerce;

import com.GeT.commerce.entity.Product;
import com.GeT.commerce.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return runner -> {
			addProduct(productRepository);
		};
	}

	private void addProduct(ProductRepository productRepository) {
		Product product = new Product();
		product.setTitle("Produktas");
		productRepository.save(product);
	}
}
