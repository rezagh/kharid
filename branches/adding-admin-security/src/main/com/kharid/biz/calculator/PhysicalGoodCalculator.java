package com.kharid.biz.calculator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.kharid.biz.ExchangeBiz;
import com.kharid.dao.GenericDao;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.model.type.PackageTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.model.type.WeightBracketEnum;
import com.kharid.model.type.WeightTypeEnum;
import com.kharid.util.ConvertUtil;
import com.kharid.util.PriceExchangeUtil;
import com.kharid.vo.PriceVO;

public class PhysicalGoodCalculator extends CalculatorTemplate{

	GenericDao genericDao;
	ExchangeBiz exchangeService;
	
	public PhysicalGoodCalculator(ExchangeBiz exchangeService, GenericDao genericDao) {
		super(exchangeService);
		this.genericDao = genericDao;
		this.exchangeService = exchangeService;
	}
	
	public Long calculatePostagePriceToAus(PriceVO priceVO) throws Exception  {
		if((!StringUtils.isEmpty(priceVO.getPriceToAus()) && !NumberUtils.isNumber(priceVO.getPriceToAus())) || 
				!NumberUtils.isNumber(priceVO.getWeight())) throw new Exception("price or weight format error");
			
			Long postagePriceToAusInToman;
			if(StringUtils.isEmpty(priceVO.getPriceToAus())) postagePriceToAusInToman = 0l;
			else{
				CurrencyTypeEnum fromUnit = CurrencyTypeEnum.valueOf(priceVO.getPriceToAusUnit());
				postagePriceToAusInToman = exchangeService.convertToToman(new Double(priceVO.getPriceToAus()), fromUnit);
			}

			return postagePriceToAusInToman;
	}

	
	public Long calculatePostagePriceToIran(PriceVO priceVO, PostTypeEnum postType) throws Exception{

		Double gWeight = ConvertUtil.convertToGrams(new Double(priceVO.getWeight()),WeightTypeEnum.valueOf(priceVO.getWeightUnit()));
		WeightBracketEnum weightBracket = PriceExchangeUtil.getWeightBracketFromWeight(gWeight, PackageTypeEnum.valueOf(priceVO.getPackageType()));
		Double price = genericDao.getPrice(postType,weightBracket, PackageTypeEnum.valueOf(priceVO.getPackageType()));
		Long inToman = exchangeService.convertToToman(price,CurrencyTypeEnum.AUD);
		log.debug("postage price to iran = " + inToman);
		return inToman;

	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	public void setExchangeService(ExchangeBiz exchangeService) {
		this.exchangeService = exchangeService;
	}
}