package com.kharid.exchange;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.model.type.CurrencyTypeEnum;
import com.reza.constant.Constant;
import com.reza.url.UrlUtil;

//using interbank.ir page source
public class InterbankExchange implements ExchangeFetch {
	private Log log = LogFactory.getLog(InterbankExchange.class);

	@Override
	public Map<String, Double> getExchangeRates() {

		Map<String, Double> map = new HashMap<String, Double>();
		String interbankPageSrc = UrlUtil.readUrlToString(Constant.get("INTER_BANK_EXCHANGE_URL"));
		// String pageSrc =UrlUtil.readUrlToString("http://interbank.ir");
		System.out.println(interbankPageSrc);

		map.put("AUD_IRR",getExchangeRate(interbankPageSrc,Constant.get("INTERBANK_AUD_PAGE_INDICATOR")));
		map.put("USD_IRR",getExchangeRate(interbankPageSrc,Constant.get("INTERBANK_USD_PAGE_INDICATOR")));
		map.put("EUR_IRR",getExchangeRate(interbankPageSrc,Constant.get("INTERBANK_EUR_PAGE_INDICATOR")));
		map.put("GBP_IRR",getExchangeRate(interbankPageSrc,Constant.get("INTERBANK_GBP_PAGE_INDICATOR")));
		map.put("CAD_IRR",getExchangeRate(interbankPageSrc,Constant.get("INTERBANK_CAD_PAGE_INDICATOR")));

		log.debug("returning interbank exchange : " + map);

		return map;
	}

	private Double getExchangeRate(String pageSrc, String indicator) {

		int indexofIndicator = pageSrc.indexOf(indicator);
		if (indexofIndicator < 0) {
			log.debug("indicator not found: " + indicator);
			return 0d;
		}
		String targetStr = pageSrc.substring(indexofIndicator + indicator.length() + 1, indexofIndicator + 300);
		Pattern p = Pattern.compile("([a-zA-Z-_;:?#<>\"=/\\n\\s]*)([0-9]*)([a-zA-Z-_;:?#<>\"=/\\n\\s]*)([0-9]*)");
		Matcher m = p.matcher(targetStr);
		System.out.println(m.find());
		System.out.println("g0=" + m.group(0));
		System.out.println("g1=" + m.group(1));
		System.out.println("g2=" + m.group(2));
		System.out.println("g3=" + m.group(3));
		System.out.println("g4=" + m.group(4));
		System.out.println("g count=" + m.groupCount());

		try {
			Double p1 = new Double(m.group(2));
			Double p2 = new Double(m.group(4));

			if (p1 > p2)
				return p1;
			else
				return p2;

		} catch (Exception e) {
			log.error("Error in exchange fetch. Regex g2 = " + m.group(2)
					+ " g4=" + m.group(4));
		}

		return 0d;
	}

	@Override
	public Double getExchange(CurrencyTypeEnum from, CurrencyTypeEnum to) {
		// TODO Auto-generated method stub
		return null;
	}
}
