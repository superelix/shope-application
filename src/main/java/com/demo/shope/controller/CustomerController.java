package com.demo.shope.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shope.business.CustomerService;
import com.demo.shope.entity.Customer;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/newcustomer",method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return customerService.saveCustomer
				(customer.getName(),
				customer.getAddress());
	}
	
}
