package com.cg.orders.orderservice.OrderService.models;

import java.time.LocalDate;
//import java.util.List;

//import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="orders")
public class Orders 
{
	@Transient
	public static final String SEQUENSE_NAME="OrderSequense";
	@Id
	private int orderId;
	private int customerId;
	@NotEmpty(message="Name should not be empty")
	private String fullName;
	
	
	private LocalDate orderDate;
	
	private double amountPaid;
	private String modeOfPayment;
	private Address address;
	
	private String orderStatus;
	private int quantity;
	
	
	

}
