package com.demo.shope.business;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shope.entity.Customer;
import com.demo.shope.entity.Order;
import com.demo.shope.entity.Product;
import com.demo.shope.entity.responseObject.OrderResponse;
import com.demo.shope.repository.CustomerRepository;
import com.demo.shope.repository.OrderRepository;
import com.demo.shope.repository.ProductRepository;

@Service
public class OrderService {
 
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	public Order placeOrder(int customerId,int productId) {
		
		Date date = new Date();        
		String dateToString = date.toInstant().atOffset(ZoneOffset.UTC).format( DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		Order order=new Order();
		
		Product product=productRepo.findById(productId);
		Customer customer=customerRepo.findById(customerId);
		
	    order.setCustomer(customer);
		order.setProduct(product);
		order.setDate(dateToString);
		order.setStatus("Prepared");
		
		Order savedOrder=orderRepo.save(order);
		
		return savedOrder;
	}
	
	public Order updateOrder(int id,String status) {
	  
		Order order=orderRepo.findById(id);
		order.setStatus(status);
		Order savedOrder=orderRepo.save(order);
		return savedOrder;
	}
	
	public OrderResponse fetchAllOrder(){
		List<Order> orderList= (List<Order>) orderRepo.findAll();
		OrderResponse orderResponseList=new OrderResponse();
		orderResponseList.setOrderList(orderList);
		return orderResponseList;
	}
	
	
}
