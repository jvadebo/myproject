package com.vadebo.webapp.myproject.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("SELRCT * FROM order");
		return (List<Order>) q.list();
	}
}
