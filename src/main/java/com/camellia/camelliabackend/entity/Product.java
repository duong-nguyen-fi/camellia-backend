package com.camellia.camelliabackend.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    public Product(String productId, Category category){
        this.productId = productId;
        this.category = category;
    }

    public Product(){}

    @Column(name = "product_id", unique = true, nullable = false)
    private String productId;

    @Enumerated(EnumType.STRING)
            @Column(name = "Category", nullable = false, updatable = true)
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, product_id='%s', category='%s']",
                id, productId, category);
    }
}
