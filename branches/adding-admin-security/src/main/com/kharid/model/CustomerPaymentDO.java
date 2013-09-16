package com.kharid.model;

import java.util.Date;
import java.util.List;

import com.kharid.model.type.CurrencyTypeEnum;

//payments from customers
public class CustomerPaymentDO extends BaseDO{

	public Long paymentRial;
	
	public Double paymentNonRial;
	public CurrencyTypeEnum currencyEum;
	public Date paymentDate;
	public String paymentID;
	
	public List<PurchaseItemDO> items;
}
