package com.vadebo.webapp.myproject.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vadebo.paymentclient.service.TransactionService;
import com.vadebo.paymentclient.service.exception.CreditException;
import com.vadebo.webapp.myproject.annotation.MockService;
import com.vadebo.webapp.myproject.annotation.OrderMockService;
import com.vadebo.webapp.myproject.command.OrderForm;
import com.vadebo.webapp.myproject.model.Order;
import com.vadebo.webapp.myproject.response.OrderResponse;
import com.vadebo.webapp.myproject.service.OrderService;



@Controller
@RequestMapping(value="/api/v1/Orders")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Resource(name="transactionService")
	private TransactionService transactionService;
	
	//@Resource(name="orderServiceMock")
	@Autowired
	//@Qualifier(value="orderServiceMock")
	@MockService
	@OrderMockService
	private OrderService orderServiceMock;
	
	@Resource(name="orderService")
	private OrderService orderServiceImpl;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getOrderById(Model model, HttpServletRequest request, @PathVariable int id){
		if(logger.isDebugEnabled()){
			logger.debug("Rest request made to url:" + request.getRequestURL().toString());
		}
		Order order = orderServiceMock.getOrderById(id);
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setCreated(order.getCreated());
		orderResponse.setDelivered(order.getDelivered());
		model.addAttribute(orderResponse);
		return "order";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getAllOrders(Model model, HttpServletRequest request){
		List<Order> orders = orderServiceImpl.getAll();
		if(logger.isDebugEnabled()){
			logger.debug("Rest request made to url:" + request.getRequestURL().toString());
		}
		try{
			
			//transactionService.credit(0);
		
		}catch(CreditException ex){
			logger.info("Credit card exception was cathed. " + ex.getReason());
		}
		
		model.addAttribute(orders);
		return "orderList";
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String orderPage(Model model, HttpServletRequest request){
		if(logger.isDebugEnabled()){
			logger.debug("Rest request made to url:" + request.getRequestURL().toString()+"?new");
		}
		OrderForm form = new OrderForm();
		model.addAttribute(form);
		return "newOrder";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="new")
	public String createOrderFromForm(OrderForm orderForm, Model model, HttpServletRequest request){
		if(logger.isDebugEnabled()){
			logger.debug("Rest request made to url:" + request.getRequestURL().toString());
		}
		System.out.println(orderForm);
		return "orderList";
	}
}
