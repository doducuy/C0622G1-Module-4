package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
