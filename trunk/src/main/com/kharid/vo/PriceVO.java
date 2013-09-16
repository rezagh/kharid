package com.kharid.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

public class PriceVO extends BaseVO {
	public PriceVO(){}
	
	
	
	String basePrice;
	String basePriceUnit;
	String audIrrRate;
	
	String weight;
	String weightUnit;
	
	
//-----------------------------------------------------------------------
	public String toString() {
		return new ToStringBuilder(this).
			append("basePrice", basePrice).
	    	append("weight", weight).
	    	append("weightUnit", weightUnit).
	    	
	    	toString();
	}
	
	public PriceVO(String basePrice){
		this.basePrice = basePrice;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}


	public String getBasePriceUnit() {
		return basePriceUnit;
	}

	public void setBasePriceUnit(String basePriceUnit) {
		this.basePriceUnit = basePriceUnit;
	}

	public String getAudIrrRate() {
		return audIrrRate;
	}

	public void setAudIrrRate(String audIrrRate) {
		this.audIrrRate = audIrrRate;
	}
}
