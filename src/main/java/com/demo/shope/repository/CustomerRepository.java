package com.demo.shope.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.shope.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByName(String name);
    Customer findById(int id);
}

