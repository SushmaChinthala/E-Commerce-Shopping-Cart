package com.cg.orders.orderservice.OrderService.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import com.casestudy.productservice.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product
{

  private int productId;
  private String productName;
}
