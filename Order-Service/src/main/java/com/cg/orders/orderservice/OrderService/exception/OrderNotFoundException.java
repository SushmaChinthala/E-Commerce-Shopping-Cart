package com.cg.orders.orderservice.OrderService.exception;

public class OrderNotFoundException extends RuntimeException 
{
private static final long serialVersionUID = 1L;
String message;

public OrderNotFoundException(String message) {
	
	super(message);
	this.message=message;
}

public OrderNotFoundException() {
	
}

}
