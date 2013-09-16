package com.kharid.model;

import java.util.Date;
import java.util.List;

import com.kharid.model.type.ItemStatusEnum;
import com.kharid.model.type.OrderTypeEnum;

public class OrderDO extends BaseDO{
	
	public String desc;
	public String code;
	
	public List<PurchaseItemDO> items;
	
	public UserDO customer;
	
	public Date orderDate;
	
	public List<NoteDO> notes;
	
	public OrderTypeEnum orderTypeEnum;
	

}
