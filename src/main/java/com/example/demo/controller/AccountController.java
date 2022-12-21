package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.model.CreateAccountDetails;
import com.example.demo.model.Login;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/checkAccount")
	public String checkAccount(@RequestBody Login login) {
		return accountService.validate(login);
	}

	@PostMapping("/deposit/{dAmount}")
	public String deposit(@PathVariable int dAmount) {
		return accountService.deposit(dAmount);
	}

	@PostMapping("/withdraw/{wAmount}")
	public String withdraw(@PathVariable int wAmount) {
		return accountService.withdraw(wAmount);
	}

	@GetMapping("/checkBalance")
	public String checkBalance() {
		return accountService.checkBalance();
	}

	@PostMapping("/createAccount")
	public String createAccount(@RequestBody CreateAccountDetails createAccountDetails) {
		return ("Account created Successfully and here is the details :\n"
				+ accountService.createAccount(createAccountDetails));
	}

	@PutMapping("/pinUpdate/{newPin}")
	public Account pinUpdate(@PathVariable int newPin) {
		return accountService.pinUpdate(newPin);
	}

	@PutMapping("/phoneNumberUpdate/{newPhoneNumber}")
	public Account phoneNumberUpdate(@PathVariable long newPhoneNumber) {
		return accountService.phoneNumberUpdate(newPhoneNumber);
	}
	
	@PostMapping("/forgetpinUpdate/{cid}")
	public String forgetpinUpdate(@PathVariable long cid) {
		return accountService.searchAccount(cid);
	}
	
	@PostMapping("/enterOTP/{otp}")
	public String enterOTP(@PathVariable int otp) {
		return accountService.enterOTP(otp);
	}

}
