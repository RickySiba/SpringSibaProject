package com.deloitte.varshini3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.varshini3.dao.OrderRepository;
	import com.deloitte.varshini3.entity.Orders;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/getOrders")
	public ResponseEntity<List<Orders>> getOrders() {
		List<Orders> ordersList = orderRepository.findAll();
		return new ResponseEntity<List<Orders>>(ordersList, HttpStatus.OK);

	}

	@GetMapping("/getOrder/{cid}")
	public ResponseEntity<List<Orders>> getOrderById(@PathVariable("cid") Integer cid) {
		List<Orders> orderList = orderRepository.findByCid(cid);
		return new ResponseEntity<List<Orders>>(orderList, HttpStatus.OK);
	}
}