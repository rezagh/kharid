package com.kharid.biz;

import com.kharid.model.type.CreditCardTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.vo.CreditCardVO;
import com.kharid.vo.PriceVO;


public interface PriceBiz  extends GenericBiz{
	//Double getPostagePriceToIran(Double weight, WeightTypeEnum weightUnit, PostTypeEnum postType)  throws Exception;
	//Double calculateCommission(Double price) throws Exception;
	Long calculateFinalPrice(PriceVO priceVO, PostTypeEnum postType)  throws Exception;
	
	/**
	 * gets and calculates cc details for wolworths master card
	 * @param cc
	 * @param chargeAmount in case of reloadable cards this is the amount to charge the card with
	 * @return
	 */
	CreditCardVO getgetMasterCardDetail(CreditCardTypeEnum cc, int chargeAmount);
	

	CreditCardVO getVisaCards(CreditCardTypeEnum cc);
		
}
