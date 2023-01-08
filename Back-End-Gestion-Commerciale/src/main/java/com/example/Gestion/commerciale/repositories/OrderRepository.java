package com.example.Gestion.commerciale.repositories;

import com.example.Gestion.commerciale.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Integer> {

    @Override
    List<Order> findAll();
}
