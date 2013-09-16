package com.kharid.model;

import java.util.Date;

public class NoteDO extends BaseDO{
	public UserDO from;
	public UserDO to;
	public String note;
	public Date date;
	public Boolean newNote;
}
