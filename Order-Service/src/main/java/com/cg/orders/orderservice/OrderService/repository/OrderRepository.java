package com.cg.orders.orderservice.OrderService.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import com.cg.orders.orderservice.OrderService.models.Address;
import com.cg.orders.orderservice.OrderService.models.Cart;
import com.cg.orders.orderservice.OrderService.models.Orders;

@Repository
public interface OrderRepository extends MongoRepository<Orders,Integer>
{
	List<Orders> findByCustomerId(int id);
List<Orders> findFirstByOrderId();
public List<Orders> findByFullName(String fullName);
public void save(String orderStatus);



}
