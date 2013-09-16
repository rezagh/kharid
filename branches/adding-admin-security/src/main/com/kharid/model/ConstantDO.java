package com.kharid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CONSTANTS")
public class ConstantDO extends BaseDO{

	@Column(name="CODE")
	private String code;
	
	@Column(name="VAL")
	private Long value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
}