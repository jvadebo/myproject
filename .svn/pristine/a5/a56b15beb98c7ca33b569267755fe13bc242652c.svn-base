package com.vadebo.webapp.myproject.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vadebo.webapp.myproject.model.Order;
import com.vadebo.webapp.myproject.repository.OrderRepository;

public class HibernateOrderRepositoryImpl implements OrderRepository {

	private SessionFactory sessionFactory;
	
	public HibernateOrderRepositoryImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unused")
	@Override
	public List<Order> findAll() {
		System.out.println("inside hibernate order Repository");
		Session session = sessionFactory.getCurrentSession();
		return null;
	}
}
