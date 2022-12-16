package com.deloitte.ricky.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.deloitte.ricky.dao.CustomerRepository;
import com.deloitte.ricky.entity.Customer;



@Service
public class CustomerServiceImpl implements CustomerService{


   @Autowired
   private CustomerRepository customerRepository;
    
    @Override
    public Customer getCustomer(Integer id) {
        // TODO Auto-generated method stub
        return customerRepository.findById(id).get();
    }



   @Override
    public List<Customer> getCustomers() {
        // TODO Auto-generated method stub
        return customerRepository.findAll();
    }



}