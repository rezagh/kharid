package com.kharid.biz.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.biz.ExchangeBiz;
import com.kharid.biz.PriceBiz;
import com.kharid.biz.calculator.CalculatorTemplate;
import com.kharid.biz.calculator.NonPhysicalGoodCalculator;
import com.kharid.biz.calculator.PhysicalGoodCalculator;
import com.kharid.biz.calculator.cctemplate.PrepaidMasterCalculator;
import com.kharid.biz.calculator.cctemplate.PrepaidVisaCalculator;
import com.kharid.dao.GenericDao;
import com.kharid.exchange.YahooExchange;
import com.kharid.model.type.CreditCardTypeEnum;
import com.kharid.model.type.GoodsTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.vo.CreditCardVO;
import com.kharid.vo.PriceVO;

public class PriceBizImpl extends  GenericBizImpl implements PriceBiz {

	Log log = LogFactory.getLog(PriceBizImpl.class);
	ExchangeBiz exchangeService;
	GenericDao genericDao;
	YahooExchange yahooExchange;
	
	@Override
	public Long calculateFinalPrice(PriceVO priceVO, PostTypeEnum postType) throws Exception{
		CalculatorTemplate c = null;
		
		
		switch (GoodsTypeEnum.valueOf(priceVO.getGoodType()) ){
		
		case PHYSICAL:
			c = new PhysicalGoodCalculator(exchangeService,genericDao); 
			break;
		case NON_PHYSICAL:
			c = new NonPhysicalGoodCalculator(exchangeService); 
			break;
		}

		return c.calculateTotalPrice(priceVO, postType);
	}

	public void setExchangeService(ExchangeBiz exchangeService) {
		this.exchangeService = exchangeService;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public CreditCardVO getgetMasterCardDetail(CreditCardTypeEnum cc, int chargeAmount) {
		return new PrepaidMasterCalculator(exchangeService,yahooExchange).getCreditCardDetails(cc, chargeAmount);
	}

	@Override
	public CreditCardVO getVisaCards(CreditCardTypeEnum cc) {
		return new PrepaidVisaCalculator(exchangeService,yahooExchange).getCreditCardDetails(cc);
	}

	public void setYahooExchange(YahooExchange yahooExchange) {
		this.yahooExchange = yahooExchange;
	}
}