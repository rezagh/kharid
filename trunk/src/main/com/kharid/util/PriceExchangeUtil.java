package com.kharid.util;

import org.apache.commons.lang.StringUtils;

public class PriceExchangeUtil {

	
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
	
	public static Double applyCommission(Long price, double rate) {
		Double withCommission = 0d;
		withCommission = price * rate;
		return RoundUtil.cutTo2DecimalPoints(price + withCommission);
	}

}
