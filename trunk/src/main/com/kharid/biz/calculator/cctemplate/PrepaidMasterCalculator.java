package com.kharid.biz.calculator.cctemplate;

import com.kharid.biz.ExchangeBiz;
import com.kharid.model.type.Const;
import com.kharid.model.type.CreditCardTypeEnum;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.util.PriceExchangeUtil;
import com.kharid.util.RoundUtil;
import com.kharid.vo.CreditCardVO;

public class PrepaidMasterCalculator extends  CcCalculatorTemplate {
	
	ExchangeBiz exchangeService;
	
	public PrepaidMasterCalculator (ExchangeBiz ex){
		this.exchangeService = ex;
	}
	
	public CreditCardVO getCreditCardDetails(CreditCardTypeEnum cc, int audChargeAmount){
		
		CreditCardVO ccVO = new CreditCardVO();
		
		Double aud_usd = exchangeService.getExchangeRates().get("AUD_USD");
		
		int ccPostageAUD = Const.CC_POSTAGE_FEE_AUD;
		Long ccPostageToman = exchangeService.convertToToman(new Double(ccPostageAUD), CurrencyTypeEnum.AUD);
		Double dPostageTomanWithCommision = PriceExchangeUtil.applyCommission(ccPostageToman, Const.CC_COMMISSIO);
		Long postageTomanWithCommision = RoundUtil.roundUpToInteger(dPostageTomanWithCommision);
		
		Long justCcToman = exchangeService.convertToToman(new Double(audChargeAmount), CurrencyTypeEnum.AUD) + 
							exchangeService.convertToToman(new Double(cc.getPurchasePrice()), CurrencyTypeEnum.AUD); 
		Double dJustCcTomanPlusCommission = PriceExchangeUtil.applyCommission(justCcToman, Const.CC_COMMISSIO);
		Long justCcTomanPlusCommission = RoundUtil.roundUpToInteger(dJustCcTomanPlusCommission);
		ccVO.setPrice(RoundUtil.roundupToNearestLimit(justCcTomanPlusCommission,100) + "");
		Long plusPostage = justCcTomanPlusCommission + postageTomanWithCommision;
		ccVO.setUsdPrice(RoundUtil.cutTo2DecimalPoints(aud_usd * audChargeAmount) + "");
		ccVO.setPhysicalPrice(RoundUtil.roundupToNearestLimit(plusPostage,100)+ "");
		
		return ccVO;
	}

}
