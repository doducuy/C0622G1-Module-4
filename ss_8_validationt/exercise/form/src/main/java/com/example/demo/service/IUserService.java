package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService  {
    Page<User> findAll(Pageable pageable);
    void saveUser(User user);
    User findById(int id);
}
