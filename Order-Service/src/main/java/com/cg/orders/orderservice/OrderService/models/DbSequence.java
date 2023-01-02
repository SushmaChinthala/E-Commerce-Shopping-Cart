package com.cg.orders.orderservice.OrderService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="IdSeq")
public class DbSequence
{
@Id
private String id;
private int seq;

}
