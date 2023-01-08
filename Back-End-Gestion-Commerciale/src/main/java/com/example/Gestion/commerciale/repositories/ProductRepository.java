package com.example.Gestion.commerciale.repositories;

import com.example.Gestion.commerciale.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Override
    List<Product> findAll();
}
