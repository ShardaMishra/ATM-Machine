package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.model.CreateAccountDetails;
import com.example.demo.model.Login;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;

@Service
public class AccountDao {

	Account account;
	Optional<Account> optionalAccount;

	@Autowired
	AccountRepo accountRepo;

	public String validate(Login login) {

		optionalAccount = accountRepo.findById(login.getAccountNumber());
		if (optionalAccount.isEmpty()) {
			optionalAccount = null;
			return "Entered wrong customer Id";
		} else {
			account = optionalAccount.get();
			if (account.getPin() != login.getPin()) {
				optionalAccount = null;
				account = null;
				return "Entered pin is incorrect";
			}
		}
		return AccountService.options();
	}

	public String deposit(int dAmount) {
		if (this.optionalAccount == null) {
			return "Please verify your account first";
		}
		if (dAmount % 100 != 0) {
			return "Enter multiple of 100, 200, 500, 2000";
		}
		account.setAmount(account.getAmount() + dAmount);
		accountRepo.save(account);
		optionalAccount = null;
		account = null;
		return (dAmount + " /- deposited successfully");
	}

	public String withdraw(Integer wAmount) {
		if (this.optionalAccount == null) {
			return "Please verify your account first";
		}
		if (wAmount % 100 != 0) {
			return "Enter multiple of 100, 200, 500, 2000";
		}
		if (wAmount > account.getAmount()) {
			return "Insufficient balance";
		}
		account.setAmount(account.getAmount() - wAmount);
		accountRepo.save(account);
		optionalAccount = null;
		account = null;
		return (wAmount + " /- withdrew successfully");
	}

	public String checkBalance() {
		if (this.optionalAccount == null) {
			return "Please verify your account first";
		}
		double balance=account.getAmount();
		optionalAccount = null;
		account = null;
		return (balance + "");
	}

	public Account createAccount(CreateAccountDetails createAccountDetails) {
		Account account = new Account();
		account.setUsername(createAccountDetails.getName());
		account.setMobile(createAccountDetails.getPhonenumber());
		account.setPin(createAccountDetails.getPin());
		account.setAmount(00.00);
		return accountRepo.save(account);
	}

	public Account pinUpdate(int newPin) {
		account.setPin(newPin);
		return accountRepo.save(account);

	}

	public Account phoneNumberUpdate(long newPhoneNumber) {
		account.setMobile(newPhoneNumber);
		return accountRepo.save(account);
	}

	public String searchAccount(long cid) {
		optionalAccount = accountRepo.findById(cid);
		if (optionalAccount.isEmpty()) {
			optionalAccount = null;
			return "Entered wrong customer Id";
		}
		return "Enter the four digit otp that is sent to your registered mobile number";
	}

	public String enterOTP(int otp) {
		if (otp > 999 && otp < 10000) {
			account = optionalAccount.get();
			return "Create a new pin";
		}
		optionalAccount=null;
		return "Incorrect otp entered";
	}

}
