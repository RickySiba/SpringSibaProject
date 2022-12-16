package com.deloitte.ricky.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.ricky.dao.CustomerRepository;
import com.deloitte.ricky.entity.Customer;
import com.deloitte.ricky.model.FailureResponse;
import com.deloitte.ricky.model.Order;
import com.deloitte.ricky.model.Response;
import com.deloitte.ricky.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;

	
	@GetMapping("/get/{id}")
	@HystrixCommand(fallbackMethod="orderFailureFallback")
	public ResponseEntity<?> getCustomer(@PathVariable("id") Integer id)
	{
		Customer customer=customerService.getCustomer(id);
		List<Order> ordersList=restTemplate.getForObject("http://localhost:8082/orders/getOrder/"+id,List.class);
		
		Response response=new Response(customer, ordersList);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
				
	}
	public ResponseEntity<?> orderFailureFallback(@PathVariable("id") Integer id)
	{
		Customer customer=customerService.getCustomer(id);
		FailureResponse response=new FailureResponse(customer,"Currently Order service is Down");
		return new ResponseEntity<FailureResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> customerList=customerService.getCustomers();
			return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
	}
}