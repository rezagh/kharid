package com.kharid.model;

import java.util.Date;
import java.util.List;

import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.model.type.WeightTypeEnum;

public class PostageDO extends BaseDO{
	
	public Double totalPostegePrice;
	public CurrencyTypeEnum currency;
	
	public String packageType;
	public Double packagePrice;
	
	public WeightTypeEnum weightType;
	public Double weight;
	
	public PostTypeEnum postageType;
	
	List<PurchaseItemDO> items;
	
	public Date postDate;
	public Boolean posted;
	
	public String note;
}
