package com.example.Gestion.commerciale.services;

import com.example.Gestion.commerciale.models.Order;
import com.example.Gestion.commerciale.models.Product;
import com.example.Gestion.commerciale.models.User;
import com.example.Gestion.commerciale.repositories.OrderRepository;
import com.example.Gestion.commerciale.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(int orderId, Product product) {
        Order order;
        order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            product.setOrder(order);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public Product updateProduct(int id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }

    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
