package com.eshoppingzone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.casestudy.productservice.controller.ProductController;
import com.casestudy.productservice.entity.Product;
import com.casestudy.productservice.repository.ProductRepository;
import com.casestudy.productservice.service.ProductService;

@SpringBootTest(classes= {ProductControllerTests.class})
public class ProductControllerTests 
{
	@Mock
	ProductService productService;
	
	
	@InjectMocks 
	ProductController productController;
	
	
	List<Product> products;
	Product product;
	
	@Test
	@Order(1)
	public void getAllProductsTest() {
		
		products= new ArrayList<Product>();
		products.add((new  Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123")));
		products.add((new  Product(1, "Smart Phones", "Samsung", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123")));
		
		when(productService.getAllProducts()).thenReturn(products);
		
		List<Product> result=productController.getAllProducts();
		
		assertEquals(2,result.size() );
	}
	@Test
	@Order(2)
	public void getProductByIdTest() {
		
		
		product=new Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123");
		
		int productId=1;
	
		
		when(productService.getProductById(productId)).thenReturn(product);
		
		
		ResponseEntity<Product> result=productController.getProductById(productId);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(productId, result.getBody().getProductId());
	}
	@Test
	@Order(3)
	public void addProductTest()
	{
		 product=new Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123");
		when(productService.addProduct(product)).thenReturn(product);
		ResponseEntity<Product> result=productController.addProducts(product);
		assertEquals(HttpStatus.CREATED,result.getStatusCode());
		assertEquals(product,result.getBody());
	}
	@Test
	@Order(4)
	public void getProductByTypeTest()
	{
		product=new Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123");
		String productType="Smart Phones";
		when(productService.getProductByType(productType)).thenReturn(products);
		ResponseEntity<List<Product>> result=productController.getProductByType(productType);
		assertEquals(HttpStatus.OK,result.getStatusCode());
		assertEquals(products,result.getBody());
		
	}
	@Test
	@Order(5)
	public void getProductByCategoryTest()
	{
		product=new Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123");
		String productCategory="Mobiles";
		when(productService.getProductByCategory(productCategory)).thenReturn(products);
		ResponseEntity<List<Product>> result=productController.getProductByCategory(productCategory);
		assertEquals(HttpStatus.OK,result.getStatusCode());
		assertEquals(products,result.getBody());
	}
	@Test
	@Order(6)
	public void getProductByNameTest()
	{
		product=new Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123");
		String productName="Galaxy A 30";
		when(productService.getProductByName(productName)).thenReturn(product);
		ResponseEntity<Product> result=productController.getProductByName(productName);
		assertEquals(HttpStatus.OK,result.getStatusCode());
		assertEquals(product,result.getBody());
	}
	@Test
	@Order(7)
	public void updateProductTest()
	{
		product=new Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123");
		int productId=1;
		String productName="Galaxy A 30";
		when(productService.getProductById(productId)).thenReturn(product);
		when(productService.updateProducts(productId, product)).thenReturn(product);
		ResponseEntity<Product> result=productController.updateProduct(productId, product);
		assertEquals(HttpStatus.OK,result.getStatusCode());
		assertEquals(productName,result.getBody().getProductName());
		assertEquals(productId,result.getBody().getProductId());
	}
	@Test
	@Order(8)
	public void deleteProductTest()
	{
		product=new Product(1, "Smart Phones", "Galaxy A 30", "Mobiles",5, "Good",
				"img", 45, "ghy", "abc@123");
		Map<String ,Boolean> response=new HashMap<>();
		response.put("Deleted", true);
		int productId=1;
		when(productService.getProductById(productId)).thenReturn( product);
				when(productService.deleteProductById(productId)).thenReturn(response);
				Map<String,Boolean> result=productController.deleteProduct(productId);
				assertEquals(response,result);
				
		
		
	}
	
	
}
