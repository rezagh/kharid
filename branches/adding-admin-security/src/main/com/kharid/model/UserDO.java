package com.kharid.model;

import java.util.List;

public class UserDO {
	
	public String firstName;
	public String lastName;
	public String addressENG;
	public String addressFA;
	public String email;
	public Double commission;//for just this customer
	
	public List<OrderDO> orders;
}
