package com.example.demo.repository;

import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value="select *from contract join customer on contract.customer_id= customer.id join facility on facility.id=contract.facility_id",nativeQuery=true)
    Page<Contract> findByCustomer(Pageable pageable);
}
