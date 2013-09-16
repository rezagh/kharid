package com.kharid.biz.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.biz.ExchangeBiz;
import com.kharid.exchange.ExchangeFetch;
import com.kharid.exchange.YahooExchange;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.util.RoundUtil;

public class ExchangeBizImpl implements ExchangeBiz {
	
	private static Cache currencyCache = CacheManager.getInstance().getCache("currencyCache");
	private Log log = LogFactory.getLog(ExchangeBizImpl.class);
	//private ExchangeFetch toIrrExchange;
	private YahooExchange yahooExchange;
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Double> getExchangeRates() {

		if(currencyCache.get("currency") != null ) {
			return (Map)currencyCache.get("currency").getObjectValue();
		}
		
		log.debug("Fetching rates and putting into cache.");

		//Map bmiMap = toIrrExchange.getExchangeRates();
		Map yahooMap = yahooExchange.getExchangeRates();
		
		Map all = new HashMap();
		//all.putAll(bmiMap);
		all.putAll(yahooMap);

		currencyCache.put(new Element("currency",all));
		return all;
	}
	
	public Double getExchange(CurrencyTypeEnum from, CurrencyTypeEnum to) {
		return getExchangeRates().get(from.name()+"_" + to.name());	
	}
	
	/**
	 * Converts a price to Toman using bmiExchange rates
	 * 
	 * @param price - the foreign price to convert to Toman
	 * @param priceUnit - the base unit of the currency to convert
	 * 
	 * @return - the converted price or error code
	 * @throws Exception
	 */
	public Long convertToToman(Double price, CurrencyTypeEnum priceUnit) {
		Map<String,Double> exchangeMap = getExchangeRates();
		
		Double rate = exchangeMap.get(priceUnit.name() + "_IRR");
		
		if(rate == null) return null;
		
		Double inToman = rate * price;
		
		Long intToman = RoundUtil.roundUpToInteger(inToman);
		
		return intToman;
	}


	public void setYahooExchange(YahooExchange yahooExchange) {
		this.yahooExchange = yahooExchange;
	}

}
