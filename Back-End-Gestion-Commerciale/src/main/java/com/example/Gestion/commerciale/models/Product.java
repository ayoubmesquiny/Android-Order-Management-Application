package com.example.Gestion.commerciale.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String name;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
    //@JsonIgnoreProperties("products")
    private Order order;

    public Product() {
    }

    public Product(int productId, String name, Double price, Order order) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.order = order;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
