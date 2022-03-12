package com.demo.shope;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.demo.shope.entity.Product;
import com.demo.shope.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository repo;
	
	//Test to insert only dummy entries.
	@Test
	public void testCreateProduct() {
	    Product product=new Product("apple-tablet","tablet having all latest features",32000);
	    Product savedProduct=repo.save(product);
	    assertThat(savedProduct.getId()).isGreaterThan(0);
	}
	
	
	//Test to see the list of products.
	@Test
	public void testListAllProducts() {
		Iterable<Product> productList= repo.findAll();
		productList.forEach(System.out::println);
	}

}
