package com.example.demo.service;

import com.example.demo.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(int id);
    void saveAccount(Account account);
    void deleteAccount(Account account);
}
