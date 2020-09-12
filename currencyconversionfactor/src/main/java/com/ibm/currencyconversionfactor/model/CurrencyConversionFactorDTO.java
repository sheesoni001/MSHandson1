package com.ibm.currencyconversionfactor.model;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionFactorDTO
{
	private String countryCode;
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
	public CurrencyConversionFactorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
