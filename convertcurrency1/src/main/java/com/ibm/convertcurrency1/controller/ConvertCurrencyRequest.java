package com.ibm.convertcurrency1.controller;

import org.springframework.stereotype.Component;

@Component
public class ConvertCurrencyRequest {
	
	private String countryCode;
	private double amount;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ConvertCurrencyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConvertCurrencyRequest(String countryCode, double amount) {
		super();
		this.countryCode = countryCode;
		this.amount = amount;
	}



}
