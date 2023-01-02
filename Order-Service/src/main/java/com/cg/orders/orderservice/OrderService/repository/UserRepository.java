package com.cg.orders.orderservice.OrderService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.orders.orderservice.OrderService.models.User1;




@Repository
public interface UserRepository  extends MongoRepository<User1,String>
{
User1 findByUsername(String username);
}
