package com.camellia.camelliabackend;

import com.camellia.camelliabackend.entity.Category;
import com.camellia.camelliabackend.entity.Product;
import com.camellia.camelliabackend.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    @MockBean
    private ProductService productService;

    @org.junit.jupiter.api.Test
    public void saveProduct_ThenRetrieveSame_GetOK() {
        Product savedProduct = productService.addProduct(new Product());
        //System.out.println(savedProduct.toString());
        Product retrievedProduct = productService.findProductById(savedProduct.getId());
        System.out.println(retrievedProduct.toString());
        assertNotNull(retrievedProduct);
        assertEquals(savedProduct.getProductId(), retrievedProduct.getProductId());
    }
}