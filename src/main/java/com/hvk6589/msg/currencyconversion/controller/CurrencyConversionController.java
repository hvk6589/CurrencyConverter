package com.hvk6589.msg.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hvk6589.msg.currencyconversion.dto.CurrencyConversionResponse;
import com.hvk6589.msg.currencyconversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrencyConversionService currencyConversionService;

	@GetMapping("/currency-converter/currencyfeed/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionResponse getCurrencyConverionData(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal amount) {
		return currencyConversionService.convertCurrency(from, to, amount);
	}
}
