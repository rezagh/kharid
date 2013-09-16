package com.kharid.biz.calculator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.biz.ExchangeBiz;
import com.kharid.model.type.CommissionRateEnum;
import com.kharid.model.type.ConstantCodesEnum;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.util.PriceExchangeUtil;
import com.kharid.util.RoundUtil;
import com.kharid.vo.PriceVO;

public abstract class CalculatorTemplate {
	Log log = LogFactory.getLog(CalculatorTemplate.class);
	ExchangeBiz exchangeService;
	
	public CalculatorTemplate(){}
	public CalculatorTemplate(ExchangeBiz exchangeService){
		this.exchangeService = exchangeService;
	}
	
	//All Return Toman
	public Long calculateBasePrice(PriceVO priceVO) throws NumberFormatException, Exception{
		log.debug("priceVO = " + priceVO);
		
		Double base = new Double(priceVO.getBasePrice());
		CurrencyTypeEnum fromUnit = CurrencyTypeEnum.valueOf(priceVO.getBasePriceUnit());
		return exchangeService.convertToToman(base, fromUnit);
	}
	
	public abstract Long calculatePostagePriceToAus(PriceVO priceVO) throws Exception;
	public abstract Long calculatePostagePriceToIran(PriceVO priceVO, PostTypeEnum postType) throws Exception;
	
	public Long calculateTotalPrice(PriceVO priceVO, PostTypeEnum postType) throws NumberFormatException, Exception{
		Long netTotal = calculateBasePrice(priceVO) + calculatePostagePriceToAus(priceVO) + calculatePostagePriceToIran(priceVO, postType);
		log.debug("final price physical, no commission = " + netTotal);
		
		Double totalWithCommission = PriceExchangeUtil.applyCommission(netTotal,CommissionRateEnum.GOODS);
		
		Long longValue = RoundUtil.roundUpToInteger(totalWithCommission);
		
		return RoundUtil.roundupToNearestLimit(longValue, exchangeService.getConstantValue(ConstantCodesEnum.ROUND_UP_TO_LIMIT));
	}

	public void setExchangeService(ExchangeBiz exchangeService) {
		this.exchangeService = exchangeService;
	}
}