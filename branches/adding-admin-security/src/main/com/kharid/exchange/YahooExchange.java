package com.kharid.exchange;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.model.type.CurrencyTypeEnum;
import com.reza.constant.Constant;
import com.reza.url.UrlUtil;

public class YahooExchange implements ExchangeFetch {
	private Log log = LogFactory.getLog(YahooExchange.class);
	
	public Map<String,Double> getExchangeRates() {
		Map<String,Double> map = new HashMap<String,Double>();

		map.put("USD_TO_IRR_RATE",getExchangeRate(UrlUtil.readUrlToString(Constant.get("YAHOO_EXCHANGE_URL_USD_TO_IRR"))));
		map.put("EUR_TO_IRR_RATE",getExchangeRate(UrlUtil.readUrlToString(Constant.get("YAHOO_EXCHANGE_URL_EUR_TO_IRR"))));
		map.put("GBP_TO_IRR_RATE",getExchangeRate(UrlUtil.readUrlToString(Constant.get("YAHOO_EXCHANGE_URL_GBP_TO_IRR"))));
		map.put("AUD_TO_IRR_RATE",getExchangeRate(UrlUtil.readUrlToString(Constant.get("YAHOO_EXCHANGE_URL_AUD_TO_IRR"))));
		
		log.debug("returning yahoo exchange : " + map);
		
		return map;
	}

	/**
	 * exchange string is of the form "USDIRR=X",9890.00,"2/18/2010","9:24am" 
	 * and we are only interested in the rate number
	 * 
	 * @param exchangeString - the string fetched from the exchange url
	 * @return - the exchange rate or -1 if error
	 */
	
	private Double getExchangeRate(String exchangeString){
        
		if(StringUtils.isEmpty(exchangeString)) return null;
		
		try{
    		StringTokenizer st = new StringTokenizer(exchangeString,",");
            st.nextToken();//pass the first token
    		return new Double(st.nextToken()); 
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return null;
	}

	@Override
	public Double getExchange(CurrencyTypeEnum from, CurrencyTypeEnum to) {
		String exchangeStr = "YAHOO_EXCHANGE_URL_" + from+ "_TO_" + to;
		return getExchangeRate(UrlUtil.readUrlToString(Constant.get(exchangeStr)));
	}
}
