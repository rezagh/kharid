package com.kharid.model.type;

public enum PostPriceEnum {
	AIR_0_250(0,250,"AIR",10),
	EPI_0_250(0,250,"EPI",58),
	REG_0_250(0,250,"REG",21.1),
	SEA_0_250(0,250,"SEA",7.05),
	AIR_250_500(250,500,"AIR",16),
	EPI_250_500(250,500,"EPI",58),
	REG_250_500(250,500,"REG",21.1),
	SEA_250_500(250,500,"SEA",11.2),
	AIR_500_750(500,750,"AIR",22),
	EPI_500_750(500,750,"EPI",58),
	REG_500_750(500,750,"REG",27.25),
	SEA_500_750(500,750,"SEA",15.35),
	AIR_750_1000(750,1000,"AIR",28),
	EPI_750_1000(750,1000,"EPI",58),
	REG_750_1000(750,1000,"REG",33.4),
	SEA_750_1000(750,1000,"SEA",19.5),
	AIR_1000_1250(1000,1250,"AIR",34.15),
	EPI_1000_1250(1000,1250,"EPI",58),
	REG_1000_1250(1000,1250,"REG",39.55),
	SEA_1000_1250(1000,1250,"SEA",23.65),
	AIR_1250_1500(1250,1500,"AIR",40.3),
	EPI_1250_1500(1250,1500,"EPI",58),
	REG_1250_1500(1250,1500,"REG",45.7),
	SEA_1250_1500(1250,1500,"SEA",27.8),
	AIR_1500_1750(1500,1750,"AIR",46.45),
	EPI_1500_1750(1500,1750,"EPI",58),
	REG_1500_1750(1500,1750,"REG",51.85),
	SEA_1500_1750(1500,1750,"SEA",31.95),
	AIR_1750_2000(1750,2000,"AIR",52.6),
	EPI_1750_2000(1750,2000,"EPI",58),
	REG_1750_2000(1750,2000,"REG",58),
	SEA_1750_2000(1750,2000,"SEA",36.1),
	AIR_2000_2500(2000,2500,"AIR",60.05),
	EPI_2000_2500(2000,2500,"EPI",72.9),
	SEA_2000_2500(2000,2500,"SEA",40.3),
	AIR_2500_3000(2500,3000,"AIR",67.50),
	EPI_2500_3000(2500,3000,"EPI",72.9),
	SEA_2500_3000(2500,3000,"SEA",44.5);

	int min;//grams
	int max;
	String postType;
	double price;//AUD
	
	private PostPriceEnum(int min,int max,String postType, double price){
		this.min = min;
		this.max = max;
		this.postType = postType;
		this.price  = price;
	}
	
	public static double getPrice(PostTypeEnum postTypeEnum, double weight){
		for (PostPriceEnum e : PostPriceEnum.values())
			if(e.getPostType().equals(postTypeEnum.name()) && weight >= e.getMin() && weight < e.getMax()) return e.getPrice();
		
		return -1;//TODO check the consequences
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}