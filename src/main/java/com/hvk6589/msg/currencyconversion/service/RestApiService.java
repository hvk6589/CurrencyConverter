package com.hvk6589.msg.currencyconversion.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestApiService {

	Logger logger = LoggerFactory.getLogger(RestApiService.class);

	public Map<String, Object> getCurrencyFeed(String from, String to) {
		Map<String, Map<String, Object>> responseMap = new HashMap<>();
		Map<String, Object> exchangeData = new LinkedHashMap<>();
		ResponseEntity<String> response = null;
		ObjectMapper mapper = new ObjectMapper();
		String fromCurrency = from + ".json";

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", fromCurrency);

		String url = "http://www.floatrates.com/daily/{from}";

		try {
			response = new RestTemplate().getForEntity(url, String.class, uriVariables);
			if (response != null && response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
				String currencyFeed = response.getBody();
				responseMap = mapper.readValue(currencyFeed, Map.class);
				exchangeData = responseMap.get(to);
			}
		} catch (Exception e) {
			logger.error("Exception occured", e);
		}

		return exchangeData;
	}
}
