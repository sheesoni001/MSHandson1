package com.ibm.currencyconversionfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ibm.currencyconversionfactor.model.CurrencyConversionFactor;

@Component
public interface CurrencyConversionFactorRepository extends JpaRepository<CurrencyConversionFactor, String>
{

}
