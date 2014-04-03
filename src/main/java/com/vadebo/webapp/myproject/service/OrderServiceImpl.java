package com.vadebo.webapp.myproject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vadebo.webapp.myproject.model.Order;
import com.vadebo.webapp.myproject.repository.OrderRepository;

@Transactional(readOnly=true)
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository){
		this.orderRepository = orderRepository;
	}
	
	@Override
	public Order getOrderById(int id) {
		return null;
	}

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

}
