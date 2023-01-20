package com.hvk6589.msg.currencyconversion.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvk6589.msg.currencyconversion.dto.CurrencyConversionResponse;

@Service
public class CurrencyConversionService {

	private final RestApiService restApiService;

	public CurrencyConversionService(RestApiService restApiService) {
		this.restApiService = restApiService;
	}

	public CurrencyConversionResponse convertCurrency(String from, String to, BigDecimal quantity) {
		Map<String, Object> currencyFeed = restApiService.getCurrencyFeed(from.toLowerCase(), to.toLowerCase());

		BigDecimal conversionRate = BigDecimal.valueOf((double) currencyFeed.get("rate"));
		BigDecimal convertedQuantity = conversionRate.multiply(quantity);

		return new CurrencyConversionResponse(from, to, convertedQuantity);
	}
}
