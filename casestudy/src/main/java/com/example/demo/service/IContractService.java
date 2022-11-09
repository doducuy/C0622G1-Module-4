package com.example.demo.service;

import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    void save(Contract contract);
    Page<Contract> showList(Pageable pageable);
}
