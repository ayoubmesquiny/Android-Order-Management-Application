package com.example.Gestion.commerciale.services;

import com.example.Gestion.commerciale.models.Order;
import com.example.Gestion.commerciale.models.User;
import com.example.Gestion.commerciale.repositories.OrderRepository;
import com.example.Gestion.commerciale.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(int userId, Order order) {
        User user;
        user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            order.setUser(user);
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    public Order updateOrder(int id, Order order) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setOrder(order.getOrder());
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }

    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
