package com.capgemini.eshoppingzone.walletservice.WalletService.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.eshoppingzone.walletservice.WalletService.models.Ewallet;
import com.capgemini.eshoppingzone.walletservice.WalletService.models.Statement;
import com.capgemini.eshoppingzone.walletservice.WalletService.models.TransactionType;
import com.capgemini.eshoppingzone.walletservice.WalletService.repository.EwalletRepository;
import com.capgemini.eshoppingzone.walletservice.WalletService.repository.StatementRepository;

@Service
public class EwalletServiceImpl implements EwalletService {
	@Autowired
	EwalletRepository ewalletRepository;
	@Autowired
	StatementRepository statementRepository;

	@Override
	public List<Ewallet> getWallets() 
	{
		return ewalletRepository.findAll();
	}

	@Override
	public Ewallet addWalletForProfile(int profileId) 
	{
		Ewallet newWallet=new Ewallet(profileId,0,new ArrayList<String>());
		return ewalletRepository.save(newWallet);
	}

	@Override
	public void addMoney(int profileId, double amount)
	{
	Ewallet ewallet=ewalletRepository.findByProfileId(profileId);
	double totalBal=amount+ewallet.getCurrentBalance();
	ewallet.setCurrentBalance(totalBal);
	ewalletRepository.save(ewallet);
	Statement stmt=new Statement(profileId,TransactionType.CREDIT,amount,LocalDateTime.of(LocalDate.now(), LocalTime.now()),ewallet);
    statementRepository.save(stmt);
	}

	@Override
	public void doTransaction(int profileId, double amount)
	{
	Ewallet ewallet=ewalletRepository.findByProfileId(profileId);
	double totalBal=ewallet.getCurrentBalance()-amount;
	ewallet.setCurrentBalance(totalBal);
	ewalletRepository.save(ewallet);
	Statement stmt=new Statement(ewallet.getProfileId(),TransactionType.DEBIT,amount,LocalDateTime.of(LocalDate.now(),LocalTime.now()),ewallet);
    statementRepository.save(stmt);
	}

	@Override
	public Ewallet getWalletById(int prfileId) {
		return ewalletRepository.findByProfileId(prfileId);
	}

	@Override
	public List<Statement> getStatementById(int statementId) {
	return statementRepository.findByStatementId(statementId);
	}

	@Override
	public List<Statement> getAllStatements() {
		return statementRepository.findAll();
	}

	@Override
	public String deleteWalletById(int ewalletId) 
	{
		Ewallet ewallet=ewalletRepository.findByProfileId(ewalletId);
		ewallet.setCurrentBalance(0);
		ewalletRepository.save(ewallet);
		ewalletRepository.delete(ewallet);
		return "Wallet deleted";
	}

	@Override
	public String deleteWalletByProfileId(int profileId) 
	{
		Ewallet ewallet=ewalletRepository.findByProfileId(profileId);
		ewallet.setCurrentBalance(0);
		ewalletRepository.save(ewallet);
		ewalletRepository.delete(ewallet);
		return "Wallet deleted";
	}

}
