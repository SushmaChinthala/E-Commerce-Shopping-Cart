package com.casestudy.CartService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.CartService.entity.Cart;

@Service
public interface CartService 
{
public Cart getCartById(int cartId);
public Cart updateCart(int cartId,Cart cart);
public List<Cart> getallcarts();
public double cartTotal(Cart cart);
public Cart addCart(Cart cart);
void deleteCartById(int cartId);

}
