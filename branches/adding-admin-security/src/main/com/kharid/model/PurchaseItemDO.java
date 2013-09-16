package com.kharid.model;

import java.util.Date;
import java.util.List;

import com.kharid.model.type.CurrencyTypeEnum;
import com.kharid.model.type.ItemStatusEnum;

public class PurchaseItemDO extends BaseDO{
	public String desc;
	public String code;
	
	public SellerDO seller;
	
	public OrderDO order;
	
	//amount i paid to purchase the item
	public Double purchasePrice;
	public CurrencyTypeEnum purchasePriceCurrencyEnum;
	public String purchasePayMethod;
	public Date purchaseDate;
	
	//amount customer pays ie. i sell
	public Long sellPriceRial;
	public Double sellPrice;
	public CurrencyTypeEnum sellPriceCurrencyEnum;
	public Long rateToIRR;//rate from purchasePrice currency to IRR
	
	public Boolean postagePriceIncluded;
	
	public List<NoteDO> notes;
	
	public Date ksReceiveDate;
	public Date customerReceiveDate;
	public Boolean customerReceived;
	
	public PostageDO postage;
	
	public ItemStatusEnum itemStatus;
	
	
}
