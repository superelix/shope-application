package com.demo.shope.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shope.entity.Product;
import com.demo.shope.repository.ProductRepository;

@Service
public class ProductService {
      
	@Autowired
	private ProductRepository repo;
	
	public Product saveProduct(String name,String description,int cost) {
		Product product=new Product();
		product.setName(name);
		product.setDescription(description);
		product.setCost(cost);
		Product savedProduct=repo.save(product);
		return savedProduct;
	}
	
	
}
