package com.casestudy.CartService.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.CartService.entity.Cart;
import com.casestudy.CartService.entity.Items;
import com.casestudy.CartService.entity.Product;
import com.casestudy.CartService.repository.CartRepository;

import com.casestudy.CartService.service.CartService;
import com.casestudy.CartService.service.CartServiceImpl;



@RestController
@RequestMapping("/cart")
public class CartController
{
	@Autowired
     CartService cartService;
	@Autowired
	CartRepository cartRepository;
	 @Autowired
	 RestTemplate restTemplate;
	
	
	
	 Logger logger=LoggerFactory.getLogger(CartController.class);
	    
	    
    public CartController(CartService cartService)
    {
        this.cartService=cartService;
    }
    public CartController()
    {
        
    }
   
    @GetMapping("/getallcarts")
    public ResponseEntity<List<Cart>> getAllCarts()
    {
        return ResponseEntity.ok(cartService.getallcarts());
    }
	
    @PostMapping("/addingproducttocart/{cartId}/{productId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable int cartId,@PathVariable int productId)
    {
    Product product=restTemplate.getForObject("http://Product-Microservice/product/findById/"+productId,Product.class);
    logger.info(""+product);
    if(cartRepository.existsById(cartId))
    {
    	Cart oldCart=cartRepository.findById(cartId);
    	List<Integer> idList=new ArrayList<>();
    	List<Items> oldItem3=oldCart.getItems();
    	for(Items i : oldItem3)
    	{
    		idList.add(i.getProductId());
    	}
    	if(idList.contains(product.getProductId()))
    	{
    		logger.info("in if method");
    		List<Items> oldItem2=oldCart.getItems();
    		for(Items i : oldItem2 )
    		{
    			if(i.getProductId()==productId)
    			{
    				i.setQuantity(i.getQuantity()+1);
    			}
    		}
    		double price=0;
    		for(Items i : oldItem2)
    		{
    			price= price+ i.getPrice()*i.getQuantity();
    		}
    		oldCart.setTotalPrice(price);
    		return new ResponseEntity<> (cartService.addCart(oldCart),HttpStatus.CREATED);
    		}
    	else
    	{
    		Items items=new Items();
    		items.setProductId(productId);
    		items.setPrice(product.getPrice());
    		items.setProductName(product.getProductName());
    		items.setQuantity(1);
    		items.setImage(product.getImage());
    		List<Items> oldItems=oldCart.getItems();
    		oldItems.add(items);
    		oldCart.setItems(oldItems);
    		double price=0;
    		for(Items i : oldItems)
    		{
    			price = price+i.getPrice()*i.getQuantity();
    		}
    		oldCart.setTotalPrice(price);
    		return new ResponseEntity<> (cartService.addCart(oldCart),HttpStatus.CREATED);
    	}
    }
    	else
    	{
    		Cart cart=new Cart();
    		cart.setCartId(cartId);
    		Items items=new Items();
    		items.setProductId(productId);
    		items.setPrice(product.getPrice());
    		items.setProductName(product.getProductName());
    		items.setQuantity(1);
    		items.setImage(product.getImage());
    		List<Items> list=new ArrayList<>();
    		list.add(items);
    		cart.setItems(list);
    		double price=0;
    		for(Items i : list )
    		{
    			price=price+ i.getPrice()*i.getQuantity();
    		}
    		cart.setTotalPrice(price);
    		return new ResponseEntity<> (cartRepository.save(cart),HttpStatus.CREATED);
    		
    		}
        } 
    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable int cartId)
    {
    	return new ResponseEntity<> (cartService.getCartById(cartId),HttpStatus.CREATED);
    }

  @PutMapping("/delete/item/{productId}/{cartId}")
    public Cart deleteCartItem(@PathVariable int cartId,@PathVariable int productId)
    {
    	Product product=restTemplate.getForObject("http://Product-Microservice/product/findById/"+productId,Product.class);
    	Cart cart2=cartService.getCartById(cartId);
    	List<Items> list=new ArrayList<>();
    	list=cart2.getItems();
    	System.out.println(list);
    	list.removeIf(i->(i.getProductId()== productId));
    	cart2.setItems(list);
    	double price=0;
    	for(Items i : list)
    	{
    		price=price+i.getPrice()*i.getQuantity();
    		
    	}
    	cart2.setTotalPrice(price);
    	return cartService.updateCart(cart2.getCartId(),cart2);
    	 }
    @PutMapping("/increaseQuant/{cartId}/{productId}")
    public Cart increaseItem(@PathVariable int cartId,@PathVariable int productId )
    {
    	Cart cart=cartService.getCartById(cartId);
    	List<Items> oldItem3=cart.getItems();
    	for(Items i : oldItem3 )
    	{
    		if(i.getProductId()==productId)
    		{
    			i.setQuantity(i.getQuantity()+1);
    		
    		}
    	}
    	double price=0;
    	for(Items i : oldItem3)
    	{
    		price=price+i.getPrice()*i.getQuantity();
    		
    	}
    	cart.setTotalPrice(price);
    	return cartService.updateCart(cartId,cart);
    	 }
    @PutMapping("/decreaseQuant/{productId}/{cartId}")
    public Cart decreaseItem(@PathVariable int productId,@PathVariable int cartId)
    {
    	Cart cart=cartService.getCartById(cartId);
    	List<Items> oldItem3=cart.getItems();
    	for(Items i: oldItem3)
       {
    		if(i.getProductId()==productId)
    		{
    			i.setQuantity(i.getQuantity()-1);
    		}
       }
    	double price=0;
    	for(Items i: oldItem3)
    	{
    		price=price+i.getPrice()*i.getQuantity();
    	}
    	cart.setTotalPrice(price);
    	return cartService.updateCart(cartId, cart);
    	
    }
    @DeleteMapping("/delete/{cartId}")
    public void deleteCart(@PathVariable int cartId)
    {
    	cartService.deleteCartById(cartId);
    }
  
    }
   
    		
    		
    	
    			
    
    



