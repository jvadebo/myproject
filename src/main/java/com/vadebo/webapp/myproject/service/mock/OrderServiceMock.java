package com.vadebo.webapp.myproject.service.mock;

import java.util.Arrays;
import java.util.List;

import com.vadebo.webapp.myproject.annotation.MockService;
import com.vadebo.webapp.myproject.annotation.OrderMockService;
import com.vadebo.webapp.myproject.model.Order;
import com.vadebo.webapp.myproject.service.OrderService;

@MockService
@OrderMockService
public class OrderServiceMock implements OrderService {

	private final List<Order> orders = Arrays.asList(new Order(1)
	, new Order(2)
	, new Order(3));
	
	@Override
	public Order getOrderById(int id) {
		if(id >= orders.size())
			throw new IllegalArgumentException("The id " + id + " is to big");	
		return orders.get(id);
	}

	@Override
	public List<Order> getAll() {
		return orders;
	}

}
