package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="select * from customer join customer_type on customer.customer_type_id = customer_type.id where customer.name like :name and customer.email like :email and customer_type.name like :nameType",
            nativeQuery = true)
    Page<Customer> findByName(@Param("name") String name,
                              @Param("email") String email,
                              @Param("nameType") String nameType,
                              Pageable pageable);
}