
package com.capgemini.eshoppingzone.walletservice.WalletService.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("statement")
public class Statement
{
	@Id
	private int statementId;
	private TransactionType transactionType;
	private double amount;
    private int orderId;
	private Ewallet ewallet;
	private LocalDateTime localDateTime;
	
	
	  public Statement(int statementId, TransactionType transactionType, double
	  amount, LocalDateTime localDateTime, Ewallet ewallet) { super();
	  this.statementId = statementId; this.transactionType = transactionType;
	  this.amount = amount; this.localDateTime = localDateTime; this.ewallet =
	  ewallet; }
	 
	
	
}
