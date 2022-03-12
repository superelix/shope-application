package com.demo.shope.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.shope.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	 Order findById(int id);
}
