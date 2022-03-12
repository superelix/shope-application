package com.demo.shope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shope.business.ProductService;
import com.demo.shope.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/newproduct")
	public Product addProduct(@RequestBody Product product) {
		
		return productService.saveProduct
				(product.getName(),
				product.getDescription(),
				product.getCost());
	}
}
