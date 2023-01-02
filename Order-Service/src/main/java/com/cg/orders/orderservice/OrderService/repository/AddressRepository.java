package com.cg.orders.orderservice.OrderService.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.orders.orderservice.OrderService.models.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address,Integer>
{
public List<Address> findByCustomerId(int id);
public Address findByFullName(String fullName);
}
