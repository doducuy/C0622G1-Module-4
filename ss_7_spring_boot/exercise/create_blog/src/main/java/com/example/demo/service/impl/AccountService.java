package com.example.demo.service.impl;

import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository iAccountRepository;
    @Override
    public List<Account> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return iAccountRepository.findById(id).orElse(new Account());
    }

    @Override
    public void saveAccount(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        iAccountRepository.deleteById(account.getId());
    }
}
