package com.casestudy.exception;


public class ProductAlreadyExistsException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//universal version identifier for a serilizable class deserialization uses this number to ensud=re that a loaded class corressponds exactly to a serialized object.

	
	  public ProductAlreadyExistsException(String message) {
		  
		super(message);
		
	}
	
	public ProductAlreadyExistsException() {
		
	}

}