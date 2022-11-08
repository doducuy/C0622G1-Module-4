package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> showList(String name,String email,String nameType,Pageable pageable);
    void save(Customer customer);
    Customer findById(int id);
    void deleteById(int id);
}
