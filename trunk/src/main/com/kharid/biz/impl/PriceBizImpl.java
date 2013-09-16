package com.kharid.biz.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kharid.biz.ExchangeBiz;
import com.kharid.biz.PriceBiz;
import com.kharid.biz.calculator.cctemplate.PrepaidVisaCalculator;
import com.kharid.model.type.CommissionDO;
import com.kharid.model.type.Const;
import com.kharid.model.type.CreditCardTypeEnum;
import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.model.type.PostPriceEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.model.type.WeightTypeEnum;
import com.kharid.util.ConvertUtil;
import com.kharid.util.RoundUtil;
import com.kharid.vo.CreditCardVO;
import com.kharid.vo.PriceVO;

public class PriceBizImpl implements PriceBiz {

	Log log = LogFactory.getLog(PriceBizImpl.class);
	ExchangeBiz exchangeService;
	
	
	private double getPostagePriceToIran_AUD(PriceVO priceVO, PostTypeEnum postTypeEnum) throws Exception{
		//PackageDO packageDO =  (PackageDO)genericDao.get(PackageDO.class, new Long(priceVO.getPackageTypeId()));
		
		Double gWeight = ConvertUtil.convertToGrams(new Double(priceVO.getWeight()),WeightTypeEnum.valueOf(priceVO.getWeightUnit()));
		
		//PackageTypeEnum pkgType = null;
		
		//if(gWeight >= 500) pkgType = PackageTypeEnum.PARCEL;// above 500 is not considered letter
		//else pkgType = PackageTypeEnum.valueOf(packageDO.getPackageType());
		return PostPriceEnum.getPrice(postTypeEnum, gWeight);
		//WeightBracketEnum weightBracket = PriceExchangeUtil.getWeightBracketFromWeight(gWeight);
		//return genericDao.getPrice(postType,weightBracket);
	}

	//All Return Toman
//	private Long calculateBasePrice(PriceVO priceVO) throws NumberFormatException, Exception{
//		log.debug("priceVO = " + priceVO);
//		
//		Double base = new Double(priceVO.getBasePrice());
//		CurrencyTypeEnum fromUnit = CurrencyTypeEnum.valueOf(priceVO.getBasePriceUnit());
//		return exchangeService.convertToToman(base, fromUnit);
//	}


//	private Long calculateTotalPrice(PriceVO priceVO, PostTypeEnum postType) throws NumberFormatException, Exception{
//		double foreignCurrencyAmount = new Double(priceVO.getBasePrice());
//		int irrRate = new Integer(priceVO.getIrrRate());
//		
//		Long netTotal = calculateSimplePrice(foreignCurrencyAmount,irrRate) + calculatePostagePriceToIran(priceVO, postType);
//		
//		log.debug("final price, no commission = " + netTotal);
//		
//		Double totalWithCommission = PriceExchangeUtil.applyCommission(netTotal,CommissionRateEnum.GOODS);
//		
//		Long longValue = RoundUtil.roundUpToInteger(totalWithCommission);
//		
//		return RoundUtil.roundupToNearestLimit(longValue, exchangeService.getConstantValue(ConstantCodesEnum.ROUND_UP_TO_LIMIT));
//	}

	
	@Override
	public Long calculateFinalPrice(PriceVO priceVO, PostTypeEnum postType) throws Exception{
		double basePrice_AUD;
		
		if(! priceVO.getBasePriceUnit().equals(CurrencyTypeEnum.AUD.toString())){
			double audRate = exchangeService.getExchangeRates().get(priceVO.getBasePriceUnit() + "_AUD");
			basePrice_AUD = (audRate + Const.PAYPAL_RATE_MARGIN) * new Double (priceVO.getBasePrice());
		}else{
			basePrice_AUD = new Double (priceVO.getBasePrice());
		}
		
		double postage_AUD = 0d;
		
		if(!StringUtils.isBlank(priceVO.getWeight()))
			postage_AUD = getPostagePriceToIran_AUD(priceVO, postType);
		
		return calculateFinal(basePrice_AUD + postage_AUD, new Integer(priceVO.getAudIrrRate()));
	}

	//calculates commission and rounds to toman and gives the final price in toman.
	private Long calculateFinal(double audAmount, int audToIrrRate){
		double fcurrency = 0;
		
		//calculate commission
		for(CommissionDO c : CommissionDO.values()){
			
			if(audAmount >= c.getMinValue() && audAmount <= c.getMaxValue()){
				double commission = audAmount * c.getCommission();
				if(commission < 5) commission = 5;//this is the min commission we want
				
				fcurrency = commission + audAmount ;
			}
		}
		
		double dTotal = fcurrency * audToIrrRate;
		Long iTotal = RoundUtil.roundUpToInteger(dTotal);
		
		return RoundUtil.roundupToNearestLimit(iTotal, Const.ROUND_UP_TO_LIMIT);
	}

	public void setExchangeService(ExchangeBiz exchangeService) {
		this.exchangeService = exchangeService;
	}

	@Override
	public CreditCardVO getMasterCardDetail(CreditCardTypeEnum cc, int audChargeAmount, int audIrrRate) {
		//return new PrepaidMasterCalculator(exchangeService).getCreditCardDetails(cc, chargeAmount, audRate);
		CreditCardVO ccVO = new CreditCardVO();
		
		Double aud_usd = exchangeService.getExchangeRates().get("AUD_USD");
		
		//int ccPostageAUD = Const.CC_POSTAGE_FEE_AUD;
		//Long ccPostageToman = exchangeService.convertToToman(new Double(ccPostageAUD), CurrencyTypeEnum.AUD);
		
		//Double dPostageTomanWithCommision = calculateFinal(audChargeAmount,audRate);//PriceExchangeUtil.applyCommission(ccPostageToman, Const.CC_COMMISSIO);
		
		//Long postageTomanWithCommision = RoundUtil.roundUpToInteger(dPostageTomanWithCommision);
		
		//Long justCcToman = (cc.getPurchasePrice() + audChargeAmount) * audRate;
			
//			exchangeService.convertToToman(new Double(audChargeAmount), CurrencyTypeEnum.AUD) + 
//							exchangeService.convertToToman(new Double(cc.getPurchasePrice()), CurrencyTypeEnum.AUD); 
		
//		Double dJustCcTomanPlusCommission = PriceExchangeUtil.applyCommission(justCcToman, Const.CC_COMMISSIO);
//		Long justCcTomanPlusCommission = RoundUtil.roundUpToInteger(dJustCcTomanPlusCommission);
		
		ccVO.setPrice(calculateFinal(audChargeAmount + cc.getPurchasePrice() ,audIrrRate) + "");
		
		//Long plusPostage = justCcTomanPlusCommission + postageTomanWithCommision;
		
		ccVO.setUsdPrice(RoundUtil.cutTo2DecimalPoints(aud_usd * audChargeAmount) + "");
		
		ccVO.setPhysicalPrice(calculateFinal(audChargeAmount + cc.getPurchasePrice() + Const.CC_POSTAGE_FEE_AUD ,audIrrRate) + "");

		return ccVO;
	}

	@Override
	public CreditCardVO getVisaCards(CreditCardTypeEnum cc) {
		return new PrepaidVisaCalculator(exchangeService).getCreditCardDetails(cc);
	}
}