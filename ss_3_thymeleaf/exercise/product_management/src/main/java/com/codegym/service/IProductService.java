package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update(int id, Product product);

    void remove(int id);
}
