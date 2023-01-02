package com.cg.orders.orderservice.OrderService.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.orders.orderservice.OrderService.models.User1;
import com.cg.orders.orderservice.OrderService.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User1 user = repository.findByUsername(username);
		if (user == null) {
			return null;
		}
		String name = user.getUsername();
		String pwd = user.getPassword();

		return new User(name, pwd, new ArrayList<>());

	}
}
