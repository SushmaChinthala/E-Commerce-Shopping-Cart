package com.cg.orders.orderservice.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cg.orders.orderservice.OrderService.controller.OrderController;
import com.cg.orders.orderservice.OrderService.models.Address;
import com.cg.orders.orderservice.OrderService.models.Orders;
import com.cg.orders.orderservice.OrderService.repository.OrderRepository;
import com.cg.orders.orderservice.OrderService.service.OrderService;
import com.cg.orders.orderservice.OrderService.service.OrderServiceImpl;
//import com.eshoppingzone.profile.userprofileservice.models.UserProfile;

public class OrderControllerTests
{
	@Mock
	OrderServiceImpl orderServiceImpl;
	@InjectMocks
	OrderController orderController;
	List<Orders> orders;
	Orders order;
	Address address;
	List<Address> addresses;

	@Mock
	OrderRepository orderRepository;
	
@Test
@Order(1)
public void getAllOrdersTest()
{
	
	
	

}
}
