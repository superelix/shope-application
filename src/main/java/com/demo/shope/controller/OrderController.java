package com.demo.shope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shope.business.OrderService;
import com.demo.shope.entity.Order;
import com.demo.shope.entity.responseObject.OrderResponse;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/neworder/productidentity/{productId}/customeridentity/{customerId}")
	public Order addOrder(@PathVariable("productId") int productId,@PathVariable("customerId") int customerId) {
		
		return orderService.placeOrder
				(productId,
				 customerId);
	}
	
	@RequestMapping(value="/updateorder/{orderId}",
			method=RequestMethod.PUT)
	public Order updateOrderStatus(@RequestBody String status,@PathVariable int orderId) {
		return orderService.updateOrder(orderId,status);
		
	}
	
	@GetMapping("/fetchorder")
	public OrderResponse fetOrderResponse() {
		return orderService.fetchAllOrder();
		
	}
	
	
}
