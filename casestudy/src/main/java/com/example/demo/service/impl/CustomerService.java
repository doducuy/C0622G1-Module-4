package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> showList(String name, String email,String nameType, Pageable pageable) {
        return iCustomerRepository.findByName("%"+name+"%","%"+email+"%","%"+nameType+"%",pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
