package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.repositories.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    // Constructor injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductsCheaperThan(Double price) {
        return productRepository.findByPriceLessThan(price);
    }
}