package com.ibm.currencyconversionfactor.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currencyconversionfactor.model.CurrencyConversionFactor;
import com.ibm.currencyconversionfactor.model.CurrencyConversionFactorDTO;
import com.ibm.currencyconversionfactor.repository.CurrencyConversionFactorRepository;
import com.ibm.currencyconversionfactor.service.CurrencyConversionFactorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class CurrencyConversionFactorController 
{
	@Autowired
	CurrencyConversionFactorService exValService;
	
	
	/*
	 * @RequestMapping(path = "/currencyConversion/{countryCode}") public String
	 * getConversionFactor(@PathVariable(required = true) String countryCode) {
	 * return exValService.getConversionFactorValue(countryCode); }
	 */
	
	//@RequestMapping(path = "/currencyConversionMaster/{countryCode}")
	@RequestMapping(path = "/getConversionFactor/{countryCode}")
	public Optional<CurrencyConversionFactor> getConversionFactor(@PathVariable(required = true) String countryCode) {
		return exValService.getConversionFactorValue(countryCode);
	}

	
	@Autowired
	CurrencyConversionFactorRepository repository;
	@Autowired
	CurrencyConversionFactorDTO dto;
	@RequestMapping(path = "/getConversionFactorv1/{countryCode}")
	@HystrixCommand(fallbackMethod = "getConversionFactorValueFallback")
	public CurrencyConversionFactorDTO getConversionFactorv1(@PathVariable(required = true) String countryCode) {

		Optional<CurrencyConversionFactor> optExchangeValueMaster = repository.findById(countryCode);

		int var = 1;
		if (var==1)
		{
			throw new RuntimeException();
		}		
		
		if (optExchangeValueMaster.isPresent())
		{
			dto.setConversionFactor(optExchangeValueMaster.get().getConversionFactor());
			dto.setCountryCode(optExchangeValueMaster.get().getCountryCode());
				 return dto;
		}
		else
				 return null;

		
	}

	public CurrencyConversionFactorDTO getConversionFactorValueFallback(String countryCode)
	{

		dto.setConversionFactor(999);
		dto.setCountryCode("FAIL");
		return dto;
		
	}

	@RequestMapping(path = "/currencyConversionMasterv2/{countryCode}")
	@HystrixCommand(fallbackMethod = "getConversionFactorValueFallback1")
	public String test()
	{ 
		int var = 1;
		if (var==1)
		{
			throw new RuntimeException();
		}
		return "main";
		
		
	}
	
	public String getConversionFactorValueFallback1()
	{
				
		return "fallback";
	}

	
	
	
	//@RequestMapping(method = RequestMethod.POST, value = "/currencyConversionMaster")
	@RequestMapping(method = RequestMethod.POST, value = "/addConversionFactor")
	public String addConversionFactor(@RequestBody CurrencyConversionFactor exchangevalueMaster) {
		return exValService.addConversionFactor(exchangevalueMaster);
	}

	
	
	  //@RequestMapping(method = RequestMethod.PUT, value = "/currencyConversionMaster/{fromCountryCode}")
	@RequestMapping(method = RequestMethod.PUT, value = "/updateConversionFactor/{fromCountryCode}")
	  public String updateConversionFactor(@RequestBody CurrencyConversionFactor exchangevalueMaster,@PathVariable String fromCountryCode ) 
	   { 
		  return exValService.updateConversionFactor(fromCountryCode, exchangevalueMaster);
	  }


	
}
