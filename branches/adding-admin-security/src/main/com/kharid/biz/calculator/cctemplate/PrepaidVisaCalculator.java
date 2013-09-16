package com.kharid.biz.calculator.cctemplate;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.kharid.biz.ExchangeBiz;
import com.kharid.exchange.YahooExchange;
import com.kharid.model.type.CommissionRateEnum;
import com.kharid.model.type.ConstantCodesEnum;
import com.kharid.model.type.CreditCardTypeEnum;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.util.PriceExchangeUtil;
import com.kharid.util.RoundUtil;
import com.kharid.vo.CreditCardVO;

public class PrepaidVisaCalculator extends CcCalculatorTemplate{
	private static Cache currencyCache = CacheManager.getInstance().getCache("currencyCache");
	ExchangeBiz exchangeService;
	YahooExchange yahooExchange;
	
	public PrepaidVisaCalculator(ExchangeBiz ex, YahooExchange ye){
		this.exchangeService = ex;
		this.yahooExchange = ye;
	}
	
	public CreditCardVO getCreditCardDetails(CreditCardTypeEnum cc){
		
		CreditCardVO ccVO = new CreditCardVO();
		int ccAmount = cc.getAmount();
				
		ccVO.setAudAmount(ccAmount+"");
		int ccPostageAUD = exchangeService.getConstantValue(ConstantCodesEnum.CC_POSTAGE_FEE_AUD);
		Long ccPostageToman = exchangeService.convertToToman(new Double(ccPostageAUD), CurrencyTypeEnum.AUD);
		Double dPostageTomanWithCommision = PriceExchangeUtil.applyCommission(ccPostageToman, CommissionRateEnum.CC);
		Long postageTomanWithCommision = RoundUtil.roundUpToInteger(dPostageTomanWithCommision);
		Long justCcToman = exchangeService.convertToToman(new Double(ccAmount + cc.getPurchasePrice()), CurrencyTypeEnum.AUD);
		Double dJustCcTomanPlusCommission = PriceExchangeUtil.applyCommission(justCcToman, CommissionRateEnum.CC);
		Long justCcTomanPlusCommission = RoundUtil.roundUpToInteger(dJustCcTomanPlusCommission);
		ccVO.setPrice(RoundUtil.roundupToNearestLimit(justCcTomanPlusCommission,100)+"");
		Long plusPostage = justCcTomanPlusCommission + postageTomanWithCommision;
		ccVO.setPhysicalPrice(RoundUtil.roundupToNearestLimit(plusPostage,100)+"");
		Double aud_usd = 0d;
		if(currencyCache.get("AUD_USD") != null ) {
			aud_usd = (Double)currencyCache.get("AUD_USD").getObjectValue();
		}else{
			aud_usd = yahooExchange.getExchange(CurrencyTypeEnum.AUD, CurrencyTypeEnum.USD);
			currencyCache.put(new Element("AUD_USD",aud_usd));
		}
		Double usdPrice = ccAmount * aud_usd; 
		usdPrice = RoundUtil.cutTo2DecimalPoints(usdPrice);
		ccVO.setUsdPrice(usdPrice.toString());
		ccVO.setOrder(cc.getOrder()+"");
		return ccVO;
	}
}
