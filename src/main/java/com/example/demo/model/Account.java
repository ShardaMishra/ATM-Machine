package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long accountNumber;
	private String username;
	private int pin;
	private double amount;
	private long mobile;

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Account Details >>>>>>\n\t[\taccountNumber= " + accountNumber + ", \n\t\tusername= " + username + ", \n\t\tpin= " + pin + ", \n\t\tamount= "
				+ amount + ", \n\t\tmobile= " + mobile + "\t]";
	}

}
