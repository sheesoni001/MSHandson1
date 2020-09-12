package com.ibm.convertcurrency1.service;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.convertcurrency1.controller.ConversionFactorDTO;


//@FeignClient(name="currencyConversionMaster", url="localhost:8001")
@FeignClient(name="currencyConversionMaster")
//@RibbonClient(name="currencyConversionMaster")
public interface ConvertCurrencyFeignProxy 
{
	@RequestMapping(path="/getConversionFactor/{countryCode}")
	public  ConversionFactorDTO getConversionFactorByCC(@PathVariable String countryCode);
	
}
