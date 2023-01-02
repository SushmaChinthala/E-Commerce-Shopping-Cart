package com.cg.orders.orderservice.OrderService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.orders.orderservice.OrderService.models.Address;
import com.cg.orders.orderservice.OrderService.models.Cart;
import com.cg.orders.orderservice.OrderService.models.Orders;
import com.razorpay.RazorpayException;

@Service
public interface OrderService
{
public List<Orders> getAllOrders();
public void placeOrder(Cart cart,String mode,String fullName);
public Orders changeStatus(Orders order,int orderId);
public void deleteOrder(int orderId);
public List<Orders> getOrderByCustomerId(int customerId);
public void storeAddress(Address address);
public List<Address> getAddressByCustomerId(int customerId);
public List<Address> getAllAddress();
public Optional<Orders> getOrderById(int OrderId);
public String onlinePayment(Cart cart) throws RazorpayException;




}
