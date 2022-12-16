package com.deloitte.ricky.model;

import com.deloitte.ricky.entity.Customer;

public class FailureResponse {
	
	private Customer customers;
	private String message;
	
	public FailureResponse() {
		super();
	}
	
	public FailureResponse(Customer customers, String message) {
		super();
		this.customers = customers;
		this.message = message;
	}
	public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
