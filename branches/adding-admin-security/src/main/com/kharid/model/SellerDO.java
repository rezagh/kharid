package com.kharid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="PRICE")
public class SellerDO extends BaseDO {

	@Column(name="WEIGHT_BRACKET")
	public String name;
	public String Address;
	public String email;
	public String bizID;
	public String webURL;
	public String myUsername;
	public String myPassword;
	public String note;
}

