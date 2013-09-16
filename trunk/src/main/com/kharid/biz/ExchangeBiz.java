package com.kharid.biz;

import java.util.Map;

import com.kharid.model.type.CurrencyTypeEnum;


public interface ExchangeBiz {
	
	/**
	 * keys are like SourceCurrency_DestinationCurency i.e. USD_IRR
	 * @return
	 */
	public Map<String,Double> getExchangeRates();
	
	Long convertToToman(Double price, CurrencyTypeEnum priceUnit);
	Double getExchange(CurrencyTypeEnum from, CurrencyTypeEnum to);
}
