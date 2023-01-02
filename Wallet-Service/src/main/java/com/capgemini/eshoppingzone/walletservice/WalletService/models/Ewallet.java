package com.capgemini.eshoppingzone.walletservice.WalletService.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("Ewallet")
public class Ewallet 
{
@Id
private int walletId;
private int profileId;
private double currentBalance;
private List<String> statements;
public Ewallet(int profileId, double currentBalance, List<String> statements) {
	super();
	this.profileId = profileId;
	this.currentBalance = currentBalance;
	this.statements = statements;
}


}
