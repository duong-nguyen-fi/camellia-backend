package com.camellia.camelliabackend.service;

import com.camellia.camelliabackend.entity.Product;
import com.camellia.camelliabackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByProductId(String productId){
        return productRepository.findByProductId(productId);
    }

    public Product addProduct(Product product){
         return productRepository.save(product);
    }

    public Product findProductById(long id){
        return productRepository.getOne(id);
    }
}
