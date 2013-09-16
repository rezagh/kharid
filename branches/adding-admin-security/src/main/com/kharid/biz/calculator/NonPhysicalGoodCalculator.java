package com.kharid.biz.calculator;

import com.kharid.biz.ExchangeBiz;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.vo.PriceVO;

public class NonPhysicalGoodCalculator extends CalculatorTemplate{

	public NonPhysicalGoodCalculator(ExchangeBiz exchangeService){
		super(exchangeService);
	}

	public Long calculatePostagePriceToAus(PriceVO priceVO) {
		return 0l;
	}

	
	public Long calculatePostagePriceToIran(PriceVO priceVO, PostTypeEnum postType) {
		return 0l;
	}
}
