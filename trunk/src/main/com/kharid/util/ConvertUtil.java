package com.kharid.util;

import com.kharid.model.type.WeightTypeEnum;

public class ConvertUtil {

	/**
	 * Converts Rial to Toman by taking one digit off from right
	 * 
	 * @param rial
	 * @return
	 */
	public static long convertRialToToman(Double rial) {
		Long longValue = rial.longValue();
		return longValue/10;
	}
	

	
	/**
	 * The English representation is returned. Non-numeric chars will not be converted and will be returned as it is.
	 * 
	 * @param farsiNumber
	 * @return English representation of farsiNumber is returned.
	 */
	public static String convertFarsiToEnglishNumber(String farsiNumber) {
		String englishNumbres ="0123456789.";
		String farsiNumbers ="۰۱۲۳۴۵۶۷۸۹.";
		
		char [] farsiArray= farsiNumber.toCharArray();
		String dest = "";
		
		for(char farsiChar:farsiArray){
			int f_index = farsiNumbers.indexOf(farsiChar);
			if(f_index != -1) dest = dest + englishNumbres.charAt(f_index);
			else dest = dest + farsiChar;
		}
		
		return dest;
		
	}
	
	public static Double convertToGrams(Double weight, WeightTypeEnum weightType) {
		if(weightType.equals(WeightTypeEnum.KG)) return weight * 1000;
		else if(weightType.equals(WeightTypeEnum.POUND)) return weight * 453.6f;
		else return weight;//it is in grams
	}
}
