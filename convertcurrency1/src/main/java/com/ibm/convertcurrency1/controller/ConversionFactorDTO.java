package com.ibm.convertcurrency1.controller;

import org.springframework.stereotype.Component;

@Component
public class ConversionFactorDTO
{
	private String countryCode ;
	private double conversionFactor;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public ConversionFactorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
