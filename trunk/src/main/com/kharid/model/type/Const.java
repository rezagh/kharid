package com.kharid.model.type;

public class Const {
	public static int PACKAGING_PRICE = 3; //3$ roughly for packaging
	public static double CC_COMMISSIO = .12;
	
	
	public static int ROUND_UP_TO_LIMIT = 100; //round the the nearest 100. if round limit is 100 and amount it 17445 then we will have 17500
	public static int AUD_MASTER_CC_LIMIT = 1000; // max amount of master cc in aud that can be ordered
	public static int CC_POSTAGE_FEE_AUD = 6;//aud$ postage fee for a physical cc
	public static double PAYPAL_RATE_MARGIN = 0.03;// is added to paypal rate as it is lower usually.  

		
}
