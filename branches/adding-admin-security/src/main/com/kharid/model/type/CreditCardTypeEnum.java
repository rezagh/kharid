package com.kharid.model.type;

public enum CreditCardTypeEnum {
	Visa_50(1,50,6,"AUD"),
	Visa_100(2,100,6,"AUD"),
	Visa_200(3,200,8,"AUD"),
	Master_Woolworths(4,-1,3,"AUD");//variable amount upto 1000 AUD can be charged into it once

	int order;
	int amount;
	int purchasePrice;
	String currency;
	
	
	private CreditCardTypeEnum(int order, int amount,int purchasePrice, String currency){
		this.amount = amount;
		this.order = order;
		this.purchasePrice = purchasePrice;
		this.currency = currency;
	}


	public int getAmount() {
		return amount;
	}


	public int getPurchasePrice() {
		return purchasePrice;
	}


	public String getCurrency() {
		return currency;
	}


	public int getOrder() {
		return order;
	}
}
	