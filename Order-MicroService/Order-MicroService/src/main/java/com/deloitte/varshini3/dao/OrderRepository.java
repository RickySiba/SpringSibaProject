package com.deloitte.varshini3.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.varshini3.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	List<Orders> findByCid(Integer custid);
	Orders findByName(String name);
}