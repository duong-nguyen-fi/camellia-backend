package com.camellia.camelliabackend.repository;

import com.camellia.camelliabackend.entity.Category;
import com.camellia.camelliabackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    List<Product>  findByCategory(Category category);
    Product findByProductId(String productId);
}
