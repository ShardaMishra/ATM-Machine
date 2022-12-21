package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDao;
import com.example.demo.model.Account;
import com.example.demo.model.CreateAccountDetails;
import com.example.demo.model.Login;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;

	public String validate(Login login) {
		return accountDao.validate(login);
	}

	public static String options() {
		return "...........Login successfull............\n  < into Sharda Mishra's ATM Service >  "
				+ "\n\nNow you can process >>>>>>>>> \n1.Deposit\n2.Withdrow\n3.Check Balance\n"
				+ "4.Create Account\n5.Pin Update\n6.Phone Number Update ";
	}

	public String deposit(int dAmount) {
		return accountDao.deposit(dAmount);
	}

	public String withdraw(Integer wAmount) {
		return accountDao.withdraw(wAmount);
	}

	public String checkBalance() {
		return accountDao.checkBalance();
	}

	public Account createAccount(CreateAccountDetails createAccountDetails) {
		return accountDao.createAccount(createAccountDetails);
	}

	public Account pinUpdate(int newPin) {
		return accountDao.pinUpdate(newPin);
	}

	public Account phoneNumberUpdate(long newPhoneNumber) {
		return accountDao.phoneNumberUpdate(newPhoneNumber);
	}

	public String searchAccount(long cid) {
		return accountDao.searchAccount(cid);
	}

	public String enterOTP(int otp) {
		return accountDao.enterOTP(otp);
	}

}
