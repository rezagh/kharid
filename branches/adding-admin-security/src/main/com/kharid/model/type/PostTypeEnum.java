package com.kharid.model.type;



public enum PostTypeEnum {
	REG("Registered Post International","سفارشی","اطمینان بالا و تحویل با امضا","10-20","2"),
	AIR("Air Mail","پست هوایی","پست استاندارد - بهترین گزینه برای ایران به لحاظ قیمت و سرعت","10-20","20"),
	EPI("Express Post International","پست اکسپرس بین المللی","پست سریع با امکان ردیابی و تحویل با امضا","3-10","10"),
	ECI("Express Courier International","پیک اکسپرس بین المللی","پست بسیار سریع با امکان ردیابی و تحویل با امضا","2-10","10"),
	SEA("Sea Mail","دریایی","ارزان اما سرعت کم","-","20");
	
	
	String engName;
	String farsiName;
	String desc;
	String deliveryTime;
	String maxWeightAllowed;
	
	
	private PostTypeEnum(String engName,String farsiName,String desc, String deliveryTime,String maxWeightAllowed){
		this.engName = engName;
		this.farsiName = farsiName;
		this.desc = desc;
		this.deliveryTime = deliveryTime;
		this.maxWeightAllowed = maxWeightAllowed;
	}


	public String getDesc() {
		return desc;
	}


	public String getEngName() {
		return engName;
	}

	public String getFarsiName() {
		return farsiName;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public String getMaxWeightAllowed() {
		return maxWeightAllowed;
	}
}
