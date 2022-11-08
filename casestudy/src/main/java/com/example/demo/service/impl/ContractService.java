package com.example.demo.service.impl;

import com.example.demo.model.Contract;
import com.example.demo.repository.IContractRepository;
import com.example.demo.service.IContractService;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;
    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }
}
