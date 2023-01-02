package com.cg.orders.orderservice.OrderService.exception;

public class CustomerNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
String message;

public CustomerNotFoundException(String message) {
super(message);
this.message=message;
}

public CustomerNotFoundException() {
	
}

}
