package com.kharid.model.type;

public enum CommissionDO {
	//this is based on AUD
	
	ONE(1,100,.24),
	TWO(101,250,.19),
	THREE(251,500,.17),
	FOUR(501,1000,.14),
	FIVE(1001,Integer.MAX_VALUE,.12);
	
	private CommissionDO (long min, long max,double commission){
		this.minValue = min;
		this.maxValue = max;
		this.commission = commission;
	}
	
	long minValue;
	long maxValue;
	double commission;
	

	public long getMinValue() {
		return minValue;
	}
	public void setMinValue(long minValue) {
		this.minValue = minValue;
	}
	public long getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}

	
}
