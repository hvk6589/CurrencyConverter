package com.hvk6589.msg.currencyconversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hvk6589.msg.currencyconversion.dto.CurrencyConversionResponse;
import com.hvk6589.msg.currencyconversion.service.CurrencyConversionService;
import com.hvk6589.msg.currencyconversion.service.RestApiService;

@ExtendWith(MockitoExtension.class)
public class CurrencyConversionServiceTest {

	@InjectMocks
	CurrencyConversionService currencyConversionService;
	
	@Mock
	RestApiService restApiService;
	
	public Map<String, Object> getResponseEntityData()
	{
		Map<String, Object> currencyFeedMap = new LinkedHashMap<>();
		
		currencyFeedMap.put("code", "INR");
		currencyFeedMap.put("alphaCode", "INR");
		currencyFeedMap.put("numericCode", 356);
		currencyFeedMap.put("name", "Indian Rupee");
		currencyFeedMap.put("rate", 87.972226750566);
		currencyFeedMap.put("date", "Thu, 19 Jan 2023 23:55:01 GMT");
		currencyFeedMap.put("inverseRate", 0.01136722391756);
		
		return currencyFeedMap;
	}
	
	@Test
	public void testCurrencyConversionService()
	{
		Mockito.when(restApiService.getCurrencyFeed(any(String.class), any(String.class))).thenReturn(getResponseEntityData());
		
		CurrencyConversionResponse response = currencyConversionService.convertCurrency("EUR", "INR", BigDecimal.valueOf(1));
		
		assertEquals(BigDecimal.valueOf(87.972226750566), response.getConvertedAmount());
	}
	
}
