package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository  extends JpaRepository<Account,Integer> {
}
