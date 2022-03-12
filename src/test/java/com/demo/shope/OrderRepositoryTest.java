package com.demo.shope;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.demo.shope.entity.Customer;
import com.demo.shope.entity.Order;
import com.demo.shope.entity.Product;
import com.demo.shope.repository.OrderRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class OrderRepositoryTest {
     
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	//Test if order is being placed or not.
	@Test
	public void testPlaceOrder() {
		
		Date date = new Date();        
		String dateToString = date.toInstant().atOffset(ZoneOffset.UTC).format( DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		Customer customer=entityManager.find(Customer.class,1);
		Product product=entityManager.find(Product.class, 1);
		
		Order order=new Order();
		order.setStatus("Prepared");
		order.setDate(dateToString);
		order.setCustomer(customer);
		order.setProduct(product);
		
		Order savedOrder=repo.save(order);
		assertThat(savedOrder.getId()).isGreaterThan(0);
	}
	
	//Test to see the list of orders.
	@Test
	public void testListAllProducts() {
		Iterable<Order> ordersList= repo.findAll();
		ordersList.forEach(System.out::println);
	}
}
