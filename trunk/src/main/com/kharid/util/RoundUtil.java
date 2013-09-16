package com.kharid.util;


public class RoundUtil {
	
	/**
	 * rounds up the rial to toman. used in base currency conversions. 
	 * 16409 will be 1541
	 * 
	 * @param rial in Rial to convert to Toman
	 * @return
	 */
	public static Double roundupRialToToman(Double rial) {
		return new Double(ConvertUtil.convertRialToToman(rial) + 1);
	}

	
	/**
	 * If the limit is 500 then 1980 will be 2000 and 1430 will be 1500.
	 * 
	 * @param value the value to round to the nearest limit
	 * @param limit usually use Codes.ROUND_UP_TO_LIMIT;
	 * @return
	 */
	public static long roundupToNearestLimit(long value,long limit) {
		long nearest;
		
		long rest = value % limit;

		if( rest > limit/2) 
		  nearest = (value-rest)+limit;
		else 
		 nearest = (value-rest) + limit;
		
		return nearest;
	}
	
	public static Long roundUpToInteger(Double num) {
		Double dNum = Math.ceil(num);//round up
		return dNum.longValue();
	}
	
//	public static Double roundTo2DecimalPoints(String num){
//		return roundTo2DecimalPoints(new Double(num));
//	}

	public static Double cutTo2DecimalPoints(Double num){
		return Math.round(num*100.0)/100.0;// Limiting to two decimal points
	}
}
