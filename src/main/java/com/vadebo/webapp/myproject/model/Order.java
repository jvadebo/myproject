package com.vadebo.webapp.myproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="myproject.order")
public class Order {

	@Id
	private int id;
	private Date created = new Date();
	private Date delivered;
	
	public Order(){}
	
	public Order(int id){this.id = id;}
	
	public Order(int id, Date created, Date delivered){
		this.id = id;
		this.created = created;
		this.delivered = delivered;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getDelivered() {
		return delivered;
	}
	public void setDelivered(Date delivered) {
		this.delivered = delivered;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=").append(id).append(", created=")
				.append(created).append(", delivered=").append(delivered)
				.append("]");
		return builder.toString();
	}
	
}
