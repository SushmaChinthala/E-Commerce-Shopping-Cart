package com.cg.orders.orderservice.OrderService.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart
{
private int cartId;
private List<Items> items;
private double totalPrice;

}
