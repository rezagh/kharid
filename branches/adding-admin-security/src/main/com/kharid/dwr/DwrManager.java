package com.kharid.dwr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.biz.ExchangeBiz;
import com.kharid.biz.PriceBiz;
import com.kharid.model.type.CreditCardTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.util.PriceExchangeUtil;
import com.kharid.vo.CreditCardVO;
import com.kharid.vo.PriceVO;

public class DwrManager {
	private static final Log log = LogFactory.getLog(DwrManager.class);
	
	private ExchangeBiz exchangeBiz;
	private PriceBiz priceBiz;
	
	public List<String> getFeeds(String source) throws  Exception{
		return null;
    }

	
	public Map<String,Long> getExchange(){
		log.debug("going to fetch exchange");
		Map<String,Long> m = exchangeBiz.getExchangeRates();
		if(log.isDebugEnabled()){
			log.debug("returning exchange: "+ m);
		}
		return m;
	}
	
	private String calculateFinalPrice(PriceVO priceVO,PostTypeEnum postType){
		try{
			Long finalPrice = priceBiz.calculateFinalPrice(priceVO, postType);
			return PriceExchangeUtil.commaSeparate(finalPrice.toString());
		}catch (Exception e) {
			e.printStackTrace();
			return "?";
		}
			
	}

	public String calculateFinalPriceNonPhysical(PriceVO priceVO){
		return calculateFinalPrice(priceVO,null);
	}

	//TODO take care of farsi numbers in this method.other methods are ok
	public Map<String,String> calculateFinalPrice(PriceVO priceVO){
		
		Map<String,String> finalPrice = new HashMap<String, String>();
		
		finalPrice.put(PostTypeEnum.AIR.name(),calculateFinalPrice(priceVO,PostTypeEnum.AIR));
		finalPrice.put(PostTypeEnum.ECI.name(),calculateFinalPrice(priceVO,PostTypeEnum.ECI));
		finalPrice.put(PostTypeEnum.EPI.name(),calculateFinalPrice(priceVO,PostTypeEnum.EPI));
		finalPrice.put(PostTypeEnum.SEA.name(),calculateFinalPrice(priceVO,PostTypeEnum.SEA));
		finalPrice.put(PostTypeEnum.REG.name(),calculateFinalPrice(priceVO,PostTypeEnum.REG));

		return finalPrice;
	}

	public List<CreditCardVO> getVisaCards(){
		
		List<CreditCardVO> out = new ArrayList<CreditCardVO>();
		
		for(CreditCardTypeEnum cc : CreditCardTypeEnum.values()){
 			if(!cc.name().startsWith("Visa")) continue;
			CreditCardVO vo = priceBiz.getVisaCards(cc);
			vo.setPrice(PriceExchangeUtil.commaSeparate(vo.getPrice()));
			vo.setPhysicalPrice(PriceExchangeUtil.commaSeparate(vo.getPhysicalPrice()));
			out.add(vo);
			log.debug("visa card being returned" + vo.toString());
		}
		return out;
	}

	public CreditCardVO getMasterCardDetail(int amount){
		CreditCardVO vo = priceBiz.getgetMasterCardDetail(CreditCardTypeEnum.Master_Woolworths,amount);
		vo.setPrice(PriceExchangeUtil.commaSeparate(vo.getPrice()));
		vo.setPhysicalPrice(PriceExchangeUtil.commaSeparate(vo.getPhysicalPrice()));
		return vo;
	}

	public void setExchangeBiz(ExchangeBiz exchangeBiz) {
		this.exchangeBiz = exchangeBiz;
	}


	public void setPriceBiz(PriceBiz priceBiz) {
		this.priceBiz = priceBiz;
	}

//	public String getPostagePriceToIran(String weight,String weightUnit,String postType) {
//		String engWeight = PriceExchangeUtil.convertFarsiToEnglishNumber(weight);
//		if (!NumberUtils.isNumber(engWeight) ||  postType.equals(Codes.NO_SELECT)) return Codes.ERROR_STRING;
//		try {
//			Double price = priceBiz.getPostagePriceToIran(new Double(engWeight), WeightTypeEnum.valueOf(weightUnit), PostTypeEnum.valueOf(postType));
//			return PriceExchangeUtil.commaSeparate(price.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Codes.ERROR_STRING;
//		}
//	}
}
