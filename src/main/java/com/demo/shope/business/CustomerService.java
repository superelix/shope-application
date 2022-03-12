package com.demo.shope.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shope.entity.Customer;
import com.demo.shope.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public Customer saveCustomer(String name,String address) {
		Customer customer=new Customer();
		customer.setName(name);
		customer.setAddress(address);
	    Customer customerAlreadyPresent=repo.findByName(customer.getName());
		Customer savedCustomer=null;
	    if(customerAlreadyPresent==null) {
			savedCustomer=repo.save(customer);
		}
		return savedCustomer;
	}
}
