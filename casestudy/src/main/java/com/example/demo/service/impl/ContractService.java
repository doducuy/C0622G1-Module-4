package com.example.demo.service.impl;

import com.example.demo.model.Contract;
import com.example.demo.repository.IContractRepository;
import com.example.demo.service.IContractService;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;
    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Page<Contract> showList(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }


}
