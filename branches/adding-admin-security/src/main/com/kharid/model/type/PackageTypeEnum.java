package com.kharid.model.type;

public enum PackageTypeEnum {
	PARCEL("Parcel"),
	LETTER("Letter");//small and light parcel basically for small documents or cards
	
	String enName;
	
	private PackageTypeEnum(String enName){
		this.enName = enName;
	}
	
	public String getEnName(){
		return this.enName;
	}
}
