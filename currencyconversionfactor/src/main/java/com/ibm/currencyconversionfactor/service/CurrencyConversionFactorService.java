package com.ibm.currencyconversionfactor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.currencyconversionfactor.model.CurrencyConversionFactor;
import com.ibm.currencyconversionfactor.repository.CurrencyConversionFactorRepository;


@Service
public class CurrencyConversionFactorService
{
	
	@Autowired
	CurrencyConversionFactorRepository repository;
	
	/*
	 * public String getConversionFactorValue(String countryCode) {
	 * Optional<CurrencyConversionFactor> optExchangeValueMaster =
	 * repository.findById(countryCode);
	 * 
	 * if (optExchangeValueMaster.isPresent()) { double conFactor =
	 * optExchangeValueMaster.get().getConversionFactor(); return
	 * String.valueOf(conFactor) ; } else return "country code doest not exists";
	 * 
	 * }
	 */	
	
	public Optional<CurrencyConversionFactor> getConversionFactorValue(String countryCode)
	{
		Optional<CurrencyConversionFactor> optExchangeValueMaster = repository.findById(countryCode);
		
		if (optExchangeValueMaster.isPresent())
		{
			
				 return optExchangeValueMaster;
		}
		else
				 return null;
		
	 }

	
	public String addConversionFactor(CurrencyConversionFactor exchangevalFactor)
	{
		CurrencyConversionFactor	status=	repository.save(exchangevalFactor);
		
			 if (status!=null)
			 { 
				return "200 OK" ;
			 }
			 else
				 return "Error has occured while adding the conversion factor!";
	}
	

	public String updateConversionFactor(String countryCode, CurrencyConversionFactor exchangevalFactor)
	{
		CurrencyConversionFactor status = repository.save(exchangevalFactor);
		
			 if (status!=null)
			 { 
				return "200 OK" ;
			 }
			 else
				 return "Error has occured while updating the conversion factor!";
	}
	
	

	/*
	 * @Autowired CurrencyConversionFactorDTO dto;
	 * @HystrixCommand(fallbackMethod = "getConversionFactorValueFallback") public
	 * CurrencyConversionFactorDTO getConversionFactorv2(String countryCode) {
	 * 
	 * Optional<CurrencyConversionFactor> optExchangeValueMaster =
	 * repository.findById(countryCode);
	 * 
	 * int var = 1; if (var==1) { throw new RuntimeException(); }
	 * 
	 * if (optExchangeValueMaster.isPresent()) {
	 * dto.setConversionFactor(optExchangeValueMaster.get().getConversionFactor());
	 * dto.setCountryCode(optExchangeValueMaster.get().getCountryCode()); return
	 * dto; } else return null; }
	 */	
	
	

}
