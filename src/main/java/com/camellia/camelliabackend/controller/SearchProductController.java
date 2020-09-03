package com.camellia.camelliabackend.controller;

import com.camellia.camelliabackend.entity.ErrorResponse;
import com.camellia.camelliabackend.entity.Product;
import com.camellia.camelliabackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController(value = "/api/v1")
public class SearchProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/product")
    public Product findProductById(@RequestParam(name = "id", required = true) String productId ){
        Product product = productService.findByProductId(productId);
        if(product == null){
            throw new ErrorResponse( "Error: product_id="+productId +" not found ");
        }
        return product;
    }

    @PostMapping(path = "/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping(path = "/products")
    public List<Product> findAllProducts(){
        return productService.findAll();
    }
}
