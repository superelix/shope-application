package com.demo.shope.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.shope.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	Product findById(int id);
}
