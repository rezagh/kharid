package com.kharid.exchange;

import java.util.Map;

import com.kharid.model.type.CurrencyTypeEnum;

public interface ExchangeFetch {
	public Map<String,?> getExchangeRates();
	Double getExchange(CurrencyTypeEnum from, CurrencyTypeEnum to);
}
