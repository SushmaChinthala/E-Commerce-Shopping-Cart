package com.casestudy.CartService.repository;

//import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.CartService.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,Integer> {
public Cart findById(int cartId);


}
