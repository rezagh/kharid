package com.kharid.test;

import com.kharid.util.RoundUtil;


public class Test {
	public static void main(String args[]) {
		
		
		Number n = 123.4;
		
		Double d = (Double)n;
		System.out.println(RoundUtil.roundupToNearestLimit(72640, 100));
		System.out.println(RoundUtil.roundUpToInteger(72639.2));

		
	}
}
