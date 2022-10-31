package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void remove(Product product);
}
