package com.kharid.biz.calculator.cctemplate;

import com.kharid.biz.ExchangeBiz;
import com.kharid.exchange.YahooExchange;
import com.kharid.model.type.CommissionRateEnum;
import com.kharid.model.type.ConstantCodesEnum;
import com.kharid.model.type.CreditCardTypeEnum;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.util.PriceExchangeUtil;
import com.kharid.util.RoundUtil;
import com.kharid.vo.CreditCardVO;

public class PrepaidMasterCalculator extends  CcCalculatorTemplate {
	
	ExchangeBiz exchangeService;
	YahooExchange yahooExchange;
	
	public PrepaidMasterCalculator (ExchangeBiz ex,YahooExchange yahooExchange){
		this.exchangeService = ex;
		this.yahooExchange = yahooExchange;
	}
	
	public CreditCardVO getCreditCardDetails(CreditCardTypeEnum cc, int audChargeAmount){
		
		CreditCardVO ccVO = new CreditCardVO();
		
		Double aud_usd = yahooExchange.getExchange(CurrencyTypeEnum.AUD, CurrencyTypeEnum.USD);
		
		int ccPostageAUD = exchangeService.getConstantValue(ConstantCodesEnum.CC_POSTAGE_FEE_AUD);
		Long ccPostageToman = exchangeService.convertToToman(new Double(ccPostageAUD), CurrencyTypeEnum.AUD);
		Double dPostageTomanWithCommision = PriceExchangeUtil.applyCommission(ccPostageToman, CommissionRateEnum.CC);
		Long postageTomanWithCommision = RoundUtil.roundUpToInteger(dPostageTomanWithCommision);
		
		Long justCcToman = exchangeService.convertToToman(new Double(audChargeAmount), CurrencyTypeEnum.AUD) + 
							exchangeService.convertToToman(new Double(cc.getPurchasePrice()), CurrencyTypeEnum.AUD); 
		Double dJustCcTomanPlusCommission = PriceExchangeUtil.applyCommission(justCcToman, CommissionRateEnum.CC);
		Long justCcTomanPlusCommission = RoundUtil.roundUpToInteger(dJustCcTomanPlusCommission);
		ccVO.setPrice(RoundUtil.roundupToNearestLimit(justCcTomanPlusCommission,100) + "");
		Long plusPostage = justCcTomanPlusCommission + postageTomanWithCommision;
		ccVO.setUsdPrice(RoundUtil.cutTo2DecimalPoints(aud_usd * audChargeAmount) + "");
		ccVO.setPhysicalPrice(RoundUtil.roundupToNearestLimit(plusPostage,100)+ "");
		
		return ccVO;
	}

}
