package com.camellia.camelliabackend.controller;

import com.camellia.camelliabackend.entity.ErrorResponse;
import com.camellia.camelliabackend.entity.Product;
import com.camellia.camelliabackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
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

    @PostMapping(path = "/products"
            //,consumes = {"application/x-www-form-urlencoded;charset=UTF-8", "application/json;charset=UTF-8"}
            //,consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE}
            //,produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
            )
    public Product addProduct(@RequestBody Product product){
            //System.out.println(product);

        return productService.addProduct(product);
    }

    @GetMapping(path = "/products")
    public List<Product> findAllProducts(){
        return productService.findAll();
    }
}
