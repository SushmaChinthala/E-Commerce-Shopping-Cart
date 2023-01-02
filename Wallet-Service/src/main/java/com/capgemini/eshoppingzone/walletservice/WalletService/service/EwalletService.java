package com.capgemini.eshoppingzone.walletservice.WalletService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.eshoppingzone.walletservice.WalletService.models.Ewallet;
import com.capgemini.eshoppingzone.walletservice.WalletService.models.Statement;

@Service
public interface EwalletService 
{
public List<Ewallet> getWallets();
public Ewallet addWalletForProfile(int profileId);
public void addMoney(int profileId,double amount);
public void doTransaction(int profileId,double amount);
public Ewallet getWalletById(int prfileId);
public List<Statement> getStatementById(int statementId);
public List<Statement> getAllStatements();
public String deleteWalletById(int ewalletId);
public String deleteWalletByProfileId(int profileId);

}
