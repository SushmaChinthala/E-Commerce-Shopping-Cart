package com.capgemini.eshoppingzone.walletservice.WalletService.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.eshoppingzone.walletservice.WalletService.models.Ewallet;
import com.capgemini.eshoppingzone.walletservice.WalletService.models.Statement;
import com.capgemini.eshoppingzone.walletservice.WalletService.repository.StatementRepository;
import com.capgemini.eshoppingzone.walletservice.WalletService.service.EwalletService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/ewallet")
public class EwalletController
{
@Autowired
EwalletService ewalletService;
@Autowired
StatementRepository statementRepository;

@GetMapping("/all")
public List<Ewallet> getWallets()
{
return ewalletService.getWallets();
}
@PostMapping("/addforprofile/{profileId}")
public Ewallet addWalletForProfile(@PathVariable("profileId") int profileId)
{
	return ewalletService.addWalletForProfile(profileId);
}
@PostMapping("/addmoney/{amount}")
public String onlinePayment(@PathVariable double amount) throws RazorpayException
{
	double amt=amount;
	System.out.println(amt);
	RazorpayClient client=new RazorpayClient("rzp_test_Ua41tuUs0Iq4Yu", "eL7zbVFMBSjdz7EhkCxyTDEG");
	JSONObject options=new JSONObject();	
	options.put("amount", amt*100);
	options.put("currency", "INR");
	options.put("receipt", "txn_123456");
	Order order=client.Orders.create(options);
	System.out.println(order);
	return order.toString();
}
@PostMapping("/addmoneytowallet/{amount}/{profileId}")
public void addWallet(@PathVariable int amount,@PathVariable int profileId)
{
	ewalletService.addMoney(profileId, amount);
}
@PostMapping("/transaction/{amount}/{profileId}")
public void doTransaction(@PathVariable int profileId,@PathVariable("amount") double amount)
{
	ewalletService.doTransaction(profileId, amount);
}
@GetMapping("/getbyid/{profileId}")
public Ewallet getWalletById(@PathVariable int profileId)
{
	return ewalletService.getWalletById(profileId);
}
@GetMapping("/statement/byid/{statementId}")
public List<Statement> getStatementById(@PathVariable int statementId)
{
	return ewalletService.getStatementById(statementId);
}
@GetMapping("/statements/all")
public List<Statement> getAllStatements()
{
	return ewalletService.getAllStatements();
}
@DeleteMapping("/delete/{ewalletId}")
public String deleteWalletByEwalletId(@PathVariable("ewalletId") int ewalletId)
{
	return ewalletService.deleteWalletById(ewalletId);
}
@DeleteMapping("/deletes/{profileId}")
public String deleteWalletById(@PathVariable("profileId") int profileId)
{
    ewalletService.deleteWalletByProfileId(profileId);
	return "done";
}


}
