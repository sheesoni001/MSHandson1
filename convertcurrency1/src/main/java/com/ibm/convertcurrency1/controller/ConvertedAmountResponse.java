package com.ibm.convertcurrency1.controller;

import org.springframework.stereotype.Component;

@Component
public class ConvertedAmountResponse 
{
	private double convertedAmount;

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public ConvertedAmountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConvertedAmountResponse(double convertedAmount) {
		super();
		this.convertedAmount = convertedAmount;
	}
	
}
