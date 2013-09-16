package com.kharid.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class CreditCardVO extends BaseVO{
	
	private String audAmount;
	private String price;
	private String physicalPrice;
	private String usdPrice;
	private String order;

    public String toString() {
		return new ToStringBuilder(this,ToStringStyle.SHORT_PREFIX_STYLE).
          append("audAmount", audAmount).
          append("price", price).
          append("physicalPrice", physicalPrice).
          append("usdPrice", usdPrice).
          append("order", order).
          toString();
    }
	
	public String getAudAmount() {
		return audAmount;
	}
	public void setAudAmount(String audAmount) {
		this.audAmount = audAmount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPhysicalPrice() {
		return physicalPrice;
	}
	public void setPhysicalPrice(String physicalPrice) {
		this.physicalPrice = physicalPrice;
	}
	public String getUsdPrice() {
		return usdPrice;
	}
	public void setUsdPrice(String usdPrice) {
		this.usdPrice = usdPrice;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	
	
}
