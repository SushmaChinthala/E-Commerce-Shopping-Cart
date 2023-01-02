package com.cg.orders.orderservice.OrderService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="address")
public class Address
{
	@Transient
public static final String SEQUENSE_NAME="CustomerSequense";
	
	@Id
private int customerId;
private String fullName;
private Long mobileNumber;
private int flatNumber;
private String city;
private int pincode;
private String State;


}
