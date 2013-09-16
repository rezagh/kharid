package com.kharid.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

public class PriceVO extends BaseVO {
	public PriceVO(){}
	
	String goodType; 
	
	String basePrice;
	String basePriceUnit;
	
	String weight;
	String weightUnit;
	
	String priceToAus;
	String priceToAusUnit;
	
	String packageType;
	
	
//-----------------------------------------------------------------------
	public String toString() {
		return new ToStringBuilder(this).
			append("goodType", goodType).	
			append("basePrice", basePrice).
	    	append("basePriceUnit", basePriceUnit).
	    	append("weight", weight).
	    	append("weightUnit", weightUnit).
	    	append("priceToAus", priceToAus).
	    	append("priceToAusUnit", priceToAusUnit).
	    	
	    	toString();
	}
	
	public PriceVO(String basePrice){
		this.basePrice = basePrice;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getBasePriceUnit() {
		return basePriceUnit;
	}

	public void setBasePriceUnit(String basePriceUnit) {
		this.basePriceUnit = basePriceUnit;
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

	public String getPriceToAus() {
		return priceToAus;
	}

	public void setPriceToAus(String priceToAus) {
		this.priceToAus = priceToAus;
	}

	public String getPriceToAusUnit() {
		return priceToAusUnit;
	}

	public void setPriceToAusUnit(String priceToAusUnit) {
		this.priceToAusUnit = priceToAusUnit;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

}
