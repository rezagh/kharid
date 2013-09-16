package com.kharid.biz.impl;

import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.biz.ExchangeBiz;
import com.kharid.exchange.ExchangeFetch;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.util.RoundUtil;

public class ExchangeBizImpl extends GenericBizImpl implements ExchangeBiz {
	
	private static Cache currencyCache = CacheManager.getInstance().getCache("currencyCache");
	private Log log = LogFactory.getLog(ExchangeBizImpl.class);
	private ExchangeFetch exchange;
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Long> getExchangeRates() {

		if(currencyCache.get("currency") != null ) {
			//log.debug("returning exchange rates from the cache.");
			return (Map)currencyCache.get("currency").getObjectValue();
		}

		Map map = exchange.getExchangeRates();
		currencyCache.put(new Element("currency",map));
		return map;
	}
	
	/**
	 * Converts a price to Toman using exchange rates
	 * 
	 * @param price - the foreign price to convert to Toman
	 * @param priceUnit - the base unit of the currency to convert
	 * 
	 * @return - the converted price or error code
	 * @throws Exception
	 */
	public Long convertToToman(Double price, CurrencyTypeEnum priceUnit) {
		Map<String,Long> exchangeMap = getExchangeRates();
		
		Long rate = exchangeMap.get(priceUnit +"_TO_IRR_RATE");
		
		if(rate == null) return null;
		
		Double inToman = rate * price;
		
		Long intToman = RoundUtil.roundUpToInteger(inToman);
		
		return intToman;
	}

	public void setExchange(ExchangeFetch exchange) {
		this.exchange = exchange;
	}


}
