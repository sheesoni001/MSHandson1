package com.ibm.currencyconversionfactor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="CurrencyConversionFactor")
public class CurrencyConversionFactor {
	@Id
	@Column(name="countryCode")
	private String countryCode;
	@Column(name="conversionFactor")
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
	public CurrencyConversionFactor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrencyConversionFactor(String countryCode, double conversionFactor) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	

}
