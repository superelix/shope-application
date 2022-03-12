package com.demo.shope.entity.responseObject;

import java.util.List;

import com.demo.shope.entity.Order;

public class OrderResponse {
     
	private List<Order> orderList;
	
	public OrderResponse() {
	
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "OrderResponse [orderList=" + orderList + "]";
	}

	

	
}
