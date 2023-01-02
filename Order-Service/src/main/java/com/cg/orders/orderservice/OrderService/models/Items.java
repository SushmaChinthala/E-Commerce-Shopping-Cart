package com.cg.orders.orderservice.OrderService.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items
{
	@NotEmpty
private String productName;
	@NotEmpty
	@Min(0)
private double price;
	@Min(1)
private int quantity;
}
