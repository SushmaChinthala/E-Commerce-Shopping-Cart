package com.casestudy.CartService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.casestudy.CartService.controller.CartController;
import com.casestudy.CartService.entity.Cart;
import com.casestudy.CartService.entity.Items;
import com.casestudy.CartService.repository.CartRepository;
//import com.casestudy.CartService.repository.CartRepository;
import com.casestudy.CartService.service.CartService;

//import com.casestudy.CartService.service.CartServiceImpl;
//import com.casestudy.productservice.entity.Product;
@SpringBootTest(classes = { CartControllerTests.class })
public class CartControllerTests {
	@Mock
	CartService cartService;
	@Mock
	CartRepository cartRepository;

	@InjectMocks
	CartController cartController;

	List<Cart> carts;
	Cart cart;
	Items item;
	List<Items> items;

	@Test
	@Order(1)
	public void getAllCartTest() {

		carts = new ArrayList<Cart>();
		items = new ArrayList<Items>();
		items.add(new Items(1, "killer", 200, 1, "hjhg"));
		carts.add((new Cart(1, 200, items)));
		carts.add((new Cart(2, 200, items)));
		when(cartService.getallcarts()).thenReturn(carts);
        ResponseEntity<List<Cart>> result = cartController.getAllCarts();
		assertEquals(carts, result.getBody());

	}

	@Test
	@Order(2)
	public void getCartByIdTest() {

		items = new ArrayList<Items>();
		items.add(new Items(1, "killer", 200, 1, "hjgy"));
        cart = new Cart(1, 200, items);
        int cartId = 1;
        when(cartService.getCartById(cartId)).thenReturn(cart);
		ResponseEntity<Cart> result = cartController.getCartById(cartId);
        assertEquals(cartId, result.getBody().getCartId());
	}
	@Test
	@Order(3)
	public void updateCartTest()
	{
		items = new ArrayList<Items>();
		items.add(new Items(1, "killer", 200, 1, "hjgy"));
        cart = new Cart(1, 200, items);
        int cartId=1;
        when(cartService.getCartById(cartId)).thenReturn(cart);
        when(cartService.updateCart(cartId, cart)).thenReturn(cart);
        ResponseEntity<Cart> result=cartController.getCartById(cartId);
        assertEquals(cartId,result.getBody().getCartId());
	}
	
	
        
	}
	
	

