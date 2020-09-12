package com.ibm.convertcurrency1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.convertcurrency1.controller.ConvertCurrencyRequest;

import com.ibm.convertcurrency1.service.ConvertCurrencyFeignProxy;

@RestController
public class ConvertCurrencyController
{

	@Autowired
	ConvertCurrencyFeignProxy feign;

	@Autowired
	ConvertedAmountResponse finalAmount;
	@RequestMapping(method=RequestMethod.POST,path="/convertCurrency")
	public double convertCurrencyFeign(@RequestBody ConvertCurrencyRequest req )
	{
		ConversionFactorDTO response = feign.getConversionFactorByCC(req.getCountryCode());
		
		/*
		 * System.out.println(req.getCountryCode());
		 * System.out.println(req.getAmount());
		 * System.out.println(response.getConversionFactor());
		 */		
		
		double factor =  response.getConversionFactor();
		double finalAmt = factor*req.getAmount();
		return finalAmt;
		
	}
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	@RequestMapping(method=RequestMethod.POST,path="/convertCurrency-eureka")
	public double convertCurrencyEureka(@RequestBody ConvertCurrencyRequest req)
	{
		ServiceInstance serviceInstance = loadBalancer.choose("currencyConversionMaster");
		String baseUrl=serviceInstance.getUri().toString();
		//System.out.println(serviceInstance.getUri());
		RestTemplate restTemplate =  new RestTemplate();
		baseUrl = baseUrl + "/currencyConversionMaster/" + req.getCountryCode(); 
		System.out.println(baseUrl);
		ConversionFactorDTO response = restTemplate.getForObject(baseUrl, ConversionFactorDTO.class);
		double factor =  response.getConversionFactor();
		double finalAmt = factor*req.getAmount();
	
		return finalAmt;
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/convertCurrency-eureka-hytrix")
	public double convertCurrencyEurekaHytrix(@RequestBody ConvertCurrencyRequest req)
	{
		ServiceInstance serviceInstance = loadBalancer.choose("currencyConversionMaster");
		String baseUrl=serviceInstance.getUri().toString();
		//System.out.println(serviceInstance.getUri());
		RestTemplate restTemplate =  new RestTemplate();
		baseUrl = baseUrl + "/getConversionFactorv1/" + req.getCountryCode(); 
		System.out.println(baseUrl);
		ConversionFactorDTO response = restTemplate.getForObject(baseUrl, ConversionFactorDTO.class);
		double factor =  response.getConversionFactor();
		double finalAmt = factor*req.getAmount();
	
		return finalAmt;
	}

	
	
	@RequestMapping(path = "/convertCurrency/{countryCode}")
	public String test(@PathVariable String countryCode)
	{
	 return "hello";
	}
	
	

	
	
}
