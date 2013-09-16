package com.kharid.exchange;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.util.RoundUtil;
import com.reza.constant.Constant;
import com.reza.url.UrlUtil;

public class BMIExchange implements ExchangeFetch {
	private Log log = LogFactory.getLog(BMIExchange.class);

	@Override
	public Map<String,Double> getExchangeRates(){
		Map<String,Double> map = new HashMap<String,Double>();
		String bmiStringRSS = UrlUtil.readUrlToString(Constant.get("BMI_EN_EXCHANGE_URL"));
		//String bmiStringRSS = "Currency Rates at 2010/03/02 Currency Rates http://www.bmi.ir/En/curr.aspx Iran Melli Bank Rss http://www.bmi.ir/App_Themes/Fa/images/SiteIcon/BMILogo.gif http://www.bmi.ir/ Iran Melli Bank Rss 100 30 (c) 2005, BankMelli Web Site. All rights reserved. BMI WebSite Wed, 03 Mar 2010 05:42:34 GMT 2010/03/03 Iran Melli Bank Currency Rate http://www.bmi.ir EUR Buy (Rls) : 13546 <BR> Sale (Rls) : 13591 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT USD Buy (Rls) : 10010 <BR> Sale (Rls) : 10040 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT GBP Buy (Rls) : 14942 <BR> Sale (Rls) : 14997 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT AUD Buy (Rls) : 8999 <BR> Sale (Rls) : 9039 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT CAD Buy (Rls) : 9611 <BR> Sale (Rls) : 9651 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT CHF Buy (Rls) : 9255 <BR> Sale (Rls) : 9300 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT JPY100 Buy (Rls) : 11202 <BR> Sale (Rls) : 11252 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT BHD Buy (Rls) : 26556 <BR> Sale (Rls) : 26626 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT AED Buy (Rls) : 2725 <BR> Sale (Rls) : 2740 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT SAR Buy (Rls) : 2668 <BR> Sale (Rls) : 2680 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT KWD Buy (Rls) : 34657 <BR> Sale (Rls) : 34727 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT SEK Buy (Rls) : 1391 <BR> Sale (Rls) : 1403 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT NOK Buy (Rls) : 1681 <BR> Sale (Rls) : 1693 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT DKK Buy (Rls) : 1819 <BR> Sale (Rls) : 1831 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT OMR Buy (Rls) : 26001 <BR> Sale (Rls) : 26056 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT HKD Buy (Rls) : 1289 <BR> Sale (Rls) : 1304 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT robl Buy (Rls) : 334 <BR> Sale (Rls) : 346 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT";
			//"Currency Rates at 2010/03/02 Currency Rates http://www.bmi.ir/En/curr.aspx Iran Melli Bank Rss http://www.bmi.ir/App_Themes/Fa/images/SiteIcon/BMILogo.gif http://www.bmi.ir/ Iran Melli Bank Rss 100 30 (c) 2005, BankMelli Web Site. All rights reserved. BMI WebSite Wed, 03 Mar 2010 05:42:34 GMT 2010/03/03 Iran Melli Bank Currency Rate http://www.bmi.ir EUR Buy (Rls) : 13546 <BR> Sale (Rls) : 13591 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT USD Buy (Rls) : 10010 <BR> Sale (Rls) : 10040 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT GBP Buy (Rls) : 14942 <BR> Sale (Rls) : 14997 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT AUD Buy (Rls) : 8999 <BR> Sale (Rls) : 9039 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT CAD Buy (Rls) : 9611 <BR> Sale (Rls) : 9651 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT CHF Buy (Rls) : 9255 <BR> Sale (Rls) : 9300 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT JPY100 Buy (Rls) : 11202 <BR> Sale (Rls) : 11252 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT BHD Buy (Rls) : 26556 <BR> Sale (Rls) : 26626 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT AED Buy (Rls) : 2725 <BR> Sale (Rls) : 2740 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT SAR Buy (Rls) : 2668 <BR> Sale (Rls) : 2680 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT KWD Buy (Rls) : 34657 <BR> Sale (Rls) : 34727 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT SEK Buy (Rls) : 1391 <BR> Sale (Rls) : 1403 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT NOK Buy (Rls) : 1681 <BR> Sale (Rls) : 1693 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT DKK Buy (Rls) : 1819 <BR> Sale (Rls) : 1831 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT OMR Buy (Rls) : 26001 <BR> Sale (Rls) : 26056 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT HKD Buy (Rls) : 1289 <BR> Sale (Rls) : 1304 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT robl Buy (Rls) : 334 <BR> Sale (Rls) : 346 <BR> Ref (Rls) : 0 http://www.bmi.ir/En/curr.aspx?y=2010&m=3&d=2& 2010/03/02 Wed, 03 Mar 2010 05:42:34 GMT";
		
		map.put("AUD_IRR",getExchangeRateEn(bmiStringRSS,CurrencyTypeEnum.AUD));
		map.put("USD_IRR",getExchangeRateEn(bmiStringRSS,CurrencyTypeEnum.USD));
		map.put("EUR_IRR",getExchangeRateEn(bmiStringRSS,CurrencyTypeEnum.EUR));
		map.put("GBP_IRR",getExchangeRateEn(bmiStringRSS,CurrencyTypeEnum.GBP));
		
		log.debug("returning bmi exchange : " + map);
		
		return map;
	}

	public Double getExchangeRateEn(String exchangeString,CurrencyTypeEnum currency) {
		try{
			int indexOfCUrrencyString = exchangeString.indexOf(currency.name());
			String shortExchangeString = exchangeString.substring(indexOfCUrrencyString);
			int indexOFSale = shortExchangeString.indexOf("Sale");
			shortExchangeString = shortExchangeString.substring(indexOFSale,indexOFSale+ 20);
			
			Pattern numberPattern = Pattern.compile("[0-9]+");
			Matcher m = numberPattern.matcher(shortExchangeString);
			
			if (m.find()){
				//Adding a margin to make it closer to market price
				int margin = 0;//genericService.getConstantValue(Const.TO_IRR_RATE_MARGIN_RIAL);
				return RoundUtil.roundupRialToToman(new Double(m.group(0)) + margin);
			}else {
				log.error("Error in exchange."+
						" exchangeString = " + exchangeString+
						" shortExchangeString" + shortExchangeString);
				return null;
			}
		}catch(Exception e) {
			log.error("Error in exchange" +
					" exchangeString = " + exchangeString +
					" currency = " + currency);
			return null;
		}
	}
	
	private Double getExchangeRate_Farsi(String exchangeString,CurrencyTypeEnum currency) {
		exchangeString = "Ù†Ø±Ø® Ø§Ø±Ø²Ù‡Ø§ÛŒ Ø±Ø§ÛŒØ¬ Ø¯Ø± ØªØ§Ø±ÛŒØ® 1388/12/11 Ù†Ø±Ø® Ø§Ø±Ø²Ù‡Ø§ÛŒ Ø±Ø§ÛŒØ¬ http://www.bmi.ir/Fa/curr.aspx Rss Ø¨Ø§Ù†Ú© Ù…Ù„ÛŒ Ø§ÛŒØ±Ø§Ù† http://www.bmi.ir/App_Themes/Fa/images/SiteIcon/BMILogo.gif http://www.bmi.ir/ Rss Ø¨Ø§Ù†Ú© Ù…Ù„ÛŒ Ø§ÛŒØ±Ø§Ù† 100 30 (c) 2005, BankMelli Web Site. All rights reserved. BMI WebSite Tue, 02 Mar 2010 12:39:20 GMT 1388/12/11 Ø¨Ø§Ù†Ú© Ù…Ù„ÛŒ Ø§ÛŒØ±Ø§Ù† Ù†Ø±Ø® Ø§Ø±Ø²Ù‡Ø§ÛŒ Ø±Ø§ÛŒØ¬ http://www.bmi.ir ÛŒÙˆØ±Ùˆ - EUR Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 13546 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 13591 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø¯Ù„Ø§Ø± Ø¢Ù…Ø±ÙŠÚ©Ø§ - USD Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 10010 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 10040 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ù¾ÙˆÙ†Ø¯ Ø§Ù†Ú¯Ù„ÛŒØ³ - GBP Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 14942 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 14997 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø¯Ù„Ø§Ø± Ø§Ø³ØªØ±Ø§Ù„ÛŒØ§ " +
		"- AUD Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 8999 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 9039 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø¯Ù„Ø§Ø± Ú©Ø§Ù†Ø§Ø¯Ø§ - CAD Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 9611 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 9651 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ù�Ø±Ø§Ù†Ú© Ø³ÙˆØ¦ÛŒØ³ - CHF Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 9255 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 9300 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT ÛŒÚ©ØµØ¯ ÛŒÙ† Ú˜Ø§Ù¾Ù† - JPY100 Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 11202 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 11252 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø¯ÛŒÙ†Ø§Ø± Ø¨Ø­Ø±ÛŒÙ† - BHD Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 26556 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 26626 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø¯Ø±Ù‡Ù… Ø§Ù…Ø§Ø±Ø§Øª - AED Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 2725 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 2740 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø±ÛŒØ§Ù„ Ø¹Ø±Ø¨Ø³ØªØ§Ù† - SAR Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 2668 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 2680 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø¯ÛŒÙ†Ø§Ø± Ú©ÙˆÛŒØª - KWD Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 34657 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 34727 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ú©Ø±ÙˆÙ† Ø³ÙˆØ¦Ø¯ - SEK Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 1391 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 1403 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ú©Ø±ÙˆÙ† Ù†Ø±ÙˆÚ˜ - NOK Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 1681 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 1693 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ú©Ø±ÙˆÙ† Ø¯Ø§Ù†Ù…Ø§Ø±Ú© - DKK Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 1819 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 1831 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø±ÙŠØ§Ù„ Ø¹Ù…Ø§Ù† - OMR Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 26001 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 26056 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø¯Ù„Ø§Ø± Ù‡Ù†Ú¯ ÙƒÙ†Ú¯ - HKD Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 1289 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 1304 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT Ø±ÙˆØ¨Ù„ Ø±ÙˆØ³ÙŠÙ‡ - robl Ù‚ÛŒÙ…Øª Ø®Ø±ÛŒØ¯ : 334 <BR> Ù‚ÛŒÙ…Øª Ù�Ø±ÙˆØ´ : 346 <BR> Ù‚ÛŒÙ…Øª Ù…Ø±Ø¬Ø¹ : 0 http://www.bmi.ir/Fa/curr.aspx?y=2010&m=3&d=2& 1388/12/11 Tue, 02 Mar 2010 12:39:20 GMT";

		Double dprice1 = null, dprice2 = null;
		String price1 = null, price2 = null;

		try{
			int indexOfCurrencyString = exchangeString.indexOf(currency.name());
			String shortExchangeString = exchangeString.substring(indexOfCurrencyString, indexOfCurrencyString + 50 );
			Pattern numberPattern = Pattern.compile("[0-9]+");
			Matcher m = numberPattern.matcher(shortExchangeString);
			
			if (m.find()){
				price1 = m.group(0);
				dprice1 = new Double(price1);
			}
				
			if (m.find()){
				price2 = m.group(0);
				dprice2 = new Double(price2);
			}
		}catch(Exception e){
			log.debug("Error in exchange : " + 
					"exchangeString = " + exchangeString +  
					" currency = " + currency +
					" price1 = " + price1 +
					" price2 = " + price2);
			return null;
		}
			
		if(dprice1 > dprice2) return dprice1;
		else return dprice2;
	}

	@Override
	public Double getExchange(CurrencyTypeEnum from, CurrencyTypeEnum to) {
		// TODO Auto-generated method stub
		return null;
	}
}

