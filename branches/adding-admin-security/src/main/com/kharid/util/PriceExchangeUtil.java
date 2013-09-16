package com.kharid.util;

import org.apache.commons.lang.StringUtils;

import com.kharid.model.type.CommissionRateEnum;
import com.kharid.model.type.PackageTypeEnum;
import com.kharid.model.type.WeightBracketEnum;

public class PriceExchangeUtil {
	/**
	 * Works in grams only
	 * 
	 * @param weightInGram
	 * @return
	 */
	public static WeightBracketEnum getWeightBracketFromWeight(double weightInGram, PackageTypeEnum packageType){
		for(WeightBracketEnum wb: WeightBracketEnum.values() )
			if(weightInGram >= wb.getMin() && weightInGram < wb.getMax() && wb.getPostType().equals(packageType.name())) return wb;
		return WeightBracketEnum.ERROR;
	}
	




	/**
	 * comma separates an number: 1234 will be 1,234 or 1234.56 will be 1,234.56
	 * 
	 * @param string representation of the number to be comma separated. works for both integer and double.
	 * @return a comma separated string representation of the input number
	 */
	public static String commaSeparate(String numString){
		String floatPart = "";
		//keep the floating section to attach later
		if(numString.contains(".")){
			floatPart = numString.substring(numString.indexOf("."),numString.length());
			numString = numString.substring(0,numString.indexOf("."));
		}
		//working on the reverse is easier
		String reverse = StringUtils.reverse(numString);
		String temp= "";
		int i=3;
		for(; i < numString.length();i = i+3){
			String block = reverse.substring(i-3,i);
			temp = temp + block + ",";
		}
		//attach the remaining
		temp = temp + reverse.substring(i-3,reverse.length());
		//attach the floating section
		return StringUtils.reverse(temp) + floatPart;
	}
	
	public static Double applyCommission(Long price, CommissionRateEnum rate) {
		Double withCommission = 0d;
		
		switch (rate){
			case GOODS:
				withCommission = price * CommissionRateEnum.GOODS.getRate();
			case CC:
				withCommission = price * CommissionRateEnum.CC.getRate();
		}
		
		return RoundUtil.cutTo2DecimalPoints(price + withCommission);
	}

}
