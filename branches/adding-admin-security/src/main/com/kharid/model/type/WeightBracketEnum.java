package com.kharid.model.type;

public enum WeightBracketEnum {
	//These are in Grams
	
	_0to50_Letter(0,50,"LETTER"),
	_50to125_Letter(50,125,"LETTER"),
	_125to250_Letter(125,250,"LETTER"),
	_250to500_Letter(250,500,"LETTER"),
	
	
	_0to250_Parcel(0,250,"PARCEL"),
	_250to500_Parcel(250,500,"PARCEL"),
	_500to750_Parcel(500,750,"PARCEL"),	
	_750to1000_Parcel(750,1000,"PARCEL"),	
	_1000to1250_Parcel(1000,1250,"PARCEL"),	
	_1250to1500_Parcel(1250,1500,"PARCEL"),	
	_1500to1750_Parcel(1500,1750,"PARCEL"),	
	_1750to2000_Parcel(1750,2000,"PARCEL"),	
	_2000to2500_Parcel(2000,2500,"PARCEL"),
	_2500to3000_Parcel(2500,3000,"PARCEL"),  
	_3000to3500_Parcel(3000,3500,"PARCEL"),  
	_3500to4000_Parcel(3500,4000,"PARCEL"),  
	_4000to4500_Parcel(4000,4500,"PARCEL"),  
	_4500to5000_Parcel(4500,5000,"PARCEL"),
	_5000to5500_Parcel(5000,5500,"PARCEL"),
	_5500to6000_Parcel(5500,6000,"PARCEL"),
	_6000to6500_Parcel(6000,6500,"PARCEL"),
	_6500to7000_Parcel(6500,7000,"PARCEL"),
	_7000to7500_Parcel(7000,7500,"PARCEL"),
	_7500to8000_Parcel(7500,8000,"PARCEL"),
	_8000to8500_Parcel(8000,8500,"PARCEL"),
	_8500to9000_Parcel(8500,9000,"PARCEL"),
	_9000to9500_Parcel(9000,9500,"PARCEL"),
	_9500to10000_Parcel(9500,10000,"PARCEL"),
	_10000to10500_Parcel(10000,10500,"PARCEL"),
	_10500to11000_Parcel(10500,11000,"PARCEL"),
	_11000to11500_Parcel(11000,11500,"PARCEL"),
	_11500to12000_Parcel(11500,12000,"PARCEL"),
	_12000to12500_Parcel(12000,12500,"PARCEL"),
	_12500to13000_Parcel(12500,13000,"PARCEL"),
	_13000to13500_Parcel(13000,13500,"PARCEL"),
	_13500to14000_Parcel(13500,14000,"PARCEL"),
	_14000to14500_Parcel(14000,14500,"PARCEL"),
	_14500to15000_Parcel(14500,15000,"PARCEL"),
	_15000to15500_Parcel(15000,15500,"PARCEL"),
	_15500to16000_Parcel(15500,16000,"PARCEL"),
	_16000to16500_Parcel(16000,16500,"PARCEL"),
	_16500to17000_Parcel(16500,17000,"PARCEL"),
	_17000to17500_Parcel(17000,17500,"PARCEL"),
	_17500to18000_Parcel(17500,18000,"PARCEL"),
	_18000to18500_Parcel(18000,18500,"PARCEL"),
	_18500to19000_Parcel(18500,19000,"PARCEL"),
	_19000to19500_Parcel(19000,19500,"PARCEL"),
	_19500to20000_Parcel(19500,20000,"PARCEL"),
	
	ERROR(-1,-1,"ERROR_DOUBLE");

	int min;
	int max;
	String postType;
	
	private WeightBracketEnum(int min,int max,String postType){
		this.min = min;
		this.max = max;
		this.postType = postType;
	}
	
	public int getMin() {
		return this.min;
	}

	public int getMax() {
		return this.max;
	}
	
	public String getPostType() {
		return this.postType;
	}

}
