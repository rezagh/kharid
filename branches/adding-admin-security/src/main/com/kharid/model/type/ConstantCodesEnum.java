package com.kharid.model.type;

//the values for these are in db
public enum ConstantCodesEnum {
	ROUND_UP_TO_LIMIT, //the rounding limit 1400 will be 1500 and 1750 will be 2000
	AUD_MASTER_CC_LIMIT, // max amount of master cc in aud that can be ordered
	CC_POSTAGE_FEE_AUD,//aud$ postage fee for a physical cc
	TO_IRR_RATE_MARGIN_RIAL // margin in Rial to be added to conversions to IRR  
}
