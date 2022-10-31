package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void remove(Product product);
}
