package com.cg.orders.orderservice.OrderService.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;


import com.cg.orders.orderservice.OrderService.models.Address;
import com.cg.orders.orderservice.OrderService.models.AuthenticationRequest;
import com.cg.orders.orderservice.OrderService.models.AuthenticationResponse;
import com.cg.orders.orderservice.OrderService.models.Cart;
import com.cg.orders.orderservice.OrderService.models.JwtUtil;
import com.cg.orders.orderservice.OrderService.models.Orders;
import com.cg.orders.orderservice.OrderService.models.User1;
import com.cg.orders.orderservice.OrderService.repository.UserRepository;
import com.cg.orders.orderservice.OrderService.service.MyUserDetailsService;
import com.cg.orders.orderservice.OrderService.service.OrderService;
import com.razorpay.RazorpayException;
//import com.cg.orders.orderservice.OrderService.service.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController
{
Logger logger=LoggerFactory.getLogger(OrderController.class);
@Autowired
OrderService orderService;
@Autowired 
UserRepository userRepository;
@Autowired 
MyUserDetailsService myUserDetailsService;
@Autowired
JwtUtil jwtTokenUtil;
@Autowired 
AuthenticationManager authenticationManager;


public OrderController() {
	super();
}
@GetMapping("/getalladdress")
public List<Address> getAllAddress()
{
	return orderService.getAllAddress();
}
@GetMapping("/getallorders")
public List<Orders> getAllOrders()
{
	return orderService.getAllOrders();
}
@GetMapping("/getorderbycustomerid/{customerId}")

public List<Orders> getOrderByCustomerId(@PathVariable int customerId) {
return orderService.getOrderByCustomerId(customerId);
	
}
@GetMapping("/getaddressbycustomerid/{customerId}")
public List<Address> getAddressByCustomerId(@PathVariable int customerId)
{
	return orderService.getAddressByCustomerId(customerId);
}
@GetMapping("/findmaxbyorderid/{orderId}")
public Optional<Orders> findByMaxByOrderId(@PathVariable int orderId)
{
	return orderService.getOrderById(orderId);
}
@PostMapping("/postorder/{mode}/{fullName}")
public void addOrder(@RequestBody Cart cart,@PathVariable String mode,@PathVariable String fullName)
{
	
	orderService.placeOrder(cart,mode,fullName);
	
}
@PostMapping("/addaddress")
public void storeAddress(@RequestBody Address address)
{
	orderService.storeAddress(address);
	
}

  @PutMapping("/changeorderstatus/{orderId}") 
  public ResponseEntity<Orders> changeOrderStatus(@PathVariable int orderId,@RequestBody  Orders order) {
  logger.warn("order"+order);
  Orders newstatus = orderService.changeStatus(order, orderId); 
  
  return new ResponseEntity<> (newstatus,HttpStatus.CREATED);
  
  }
 
@DeleteMapping("/deleteorder/{orderId}")
public ResponseEntity<String> deleteOrder(@PathVariable int orderId )
{
	orderService.deleteOrder(orderId);
	return ResponseEntity.ok("Your order is deleted with orderId "+orderId);

}
@PostMapping("/pay")
public String onlinePayment(@RequestBody Cart cart) throws RazorpayException
{
	return orderService.onlinePayment(cart);
}
@PostMapping("/registration")
private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
{
    System.out.println("Sushma Chinthala");
    String username = request.getUsername();
    String password = request.getPassword();



    User1 model = new User1();
    model.setUsername(username);
    model.setPassword(password);



    try {
        userRepository.save(model);
    } catch (Exception e) {
        return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
    }
        return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
}

@RequestMapping(value="/authenticate", method=RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest  authenticationRequest) throws Exception {
    try
    {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
}
    catch (BadCredentialsException e) {
        throw new Exception("Incorrect username or password", e);
    }




    final UserDetails userDetails = myUserDetailsService
            .loadUserByUsername(authenticationRequest.getUsername());



    final String jwt = jwtTokenUtil.generateToken(userDetails);



    return ResponseEntity.ok(new AuthenticationResponse(jwt));

}


}
