package com.casestudy.CartService.entity;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*getters, setters, all arguments and no argument constructors by annotations*/
@Data
@AllArgsConstructor
@NoArgsConstructor 
/*@document- to specify custom property values*/
/*Defining collection name of mongodb to the model class*/
@Document(collection = "Product")
public class Product {
	
	 /*This helps ignoring the field by not mapping it to the database*/
	@Transient
	//It is the order in which the statements is executed	
	public static final String SEQUENSE_NAME = "product_sequense";
	/*Providing all variables required */
    /*Setting up the below variable as primary key in the collection*/
	@Id
	private int productId;
	
	
	private String productType;
	
	private String productName;
	private String category;
	

	private double rating;
	
	private String review;
	private String image;
	
	@NotNull
	private double price;
	private String description;
	
	private String specification;
	


	public static String getSequencename() {
		return SEQUENSE_NAME;
	}
	
	

	
	
	
}