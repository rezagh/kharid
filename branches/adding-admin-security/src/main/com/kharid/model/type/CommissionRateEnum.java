package com.kharid.model.type;

public enum CommissionRateEnum {
	GOODS(.20),//everything except cc
	CC(.15);//credit cards
	
	double commissionRate;
	
	private CommissionRateEnum(double rate){
		this.commissionRate = rate;
	}
	
	public double getRate(){
		return this.commissionRate;
	}
}
