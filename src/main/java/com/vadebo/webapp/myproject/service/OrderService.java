package com.vadebo.webapp.myproject.service;

import java.util.List;

import com.vadebo.webapp.myproject.model.Order;

public interface OrderService {

	public Order getOrderById(int id);
	
	public List<Order> getAll();
	
}
