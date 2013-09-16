package com.kharid.model.type;

public enum InquiryTypeEnum {
	CALCULATE_PRICE("محاسبه قیمت"),//calculate price for a customer
	CC("کارت اعتباری"),
	Enquiry("سوال"), //general inquiry
//	Abuse_Report("گزارش سوء استفاده از سیستم"), //user wants to send an abuse report
	Suggestion("پیشنهاد"), //user wants to send a suggestion
	Cooperation("همکاری"), //give us a hand
	Error_Report("گزارش خطا در سیستم"), //to report an error about the system
	Other("متفرقه");
	
	private String farsiValue;
    
	InquiryTypeEnum(String farsiValue) {
        this.farsiValue = farsiValue;
    }
    
    public String getFarsiValue() {
    	return farsiValue;
    }

}
