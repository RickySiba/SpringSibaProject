package com.deloitte.ricky.service;

import java.util.List;



import com.deloitte.ricky.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	Customer getCustomer(Integer id);
	
	
	

}
