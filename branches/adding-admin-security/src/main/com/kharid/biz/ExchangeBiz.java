package com.kharid.biz;

import java.util.Map;

import com.kharid.model.type.CurrencyTypeEnum;


public interface ExchangeBiz extends GenericBiz {
	
	/**
	 * keys are USD_TO_IRR_RATE, EUR_TO_IRR_RATE, GBP_TO_IRR_RATE, AUD_TO_IRR_RATE
	 * @return
	 */
	public Map<String,Long> getExchangeRates();
	
	Long convertToToman(Double price, CurrencyTypeEnum priceUnit);
//	public Float convertToRial(Float price, CurrencyTypeEnum priceUnit);
}
