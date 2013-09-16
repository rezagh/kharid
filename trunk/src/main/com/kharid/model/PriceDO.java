package com.kharid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name ="PRICE")
public class PriceDO extends BaseDO{
	
	@Column(name="WEIGHT_BRACKET")
	private String weightBracket;
	
	@Column(name="POST_TYPE")
	private String postType;
	
	@Column(name="PRICE")
	private String price;//TODO make this float

	public String getWeightBracket() {
		return weightBracket;
	}

	public void setWeightBracket(String weightBracket) {
		this.weightBracket = weightBracket;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
