package com.hvk6589.msg.currencyconversion.dto;

import java.math.BigDecimal;

public class CurrencyConversionResponse {
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal convertedAmount;

	public CurrencyConversionResponse() {

	}

	public CurrencyConversionResponse(String fromCurrency, String toCurrency, BigDecimal convertedAmount) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.convertedAmount = convertedAmount;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
}
