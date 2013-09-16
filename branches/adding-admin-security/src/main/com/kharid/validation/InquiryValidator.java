package com.kharid.validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kharid.model.InquiryDO;


public class InquiryValidator implements Validator {
	Log log = LogFactory.getLog(InquiryValidator.class);

	public boolean supports(Class clazz) {
    	return clazz.equals(InquiryDO.class);
    }
    
    public void validate(Object obj, Errors e) {
    	//InquiryDO inquiry = (InquiryDO)obj;
    	//if(inquiry.getUser() == null && (inquiry.getEmail() == null || inquiry.getEmail()==""))
    	ValidationUtils.rejectIfEmpty(e, "email","error_mandatory");
    	ValidationUtils.rejectIfEmpty(e, "message","error_mandatory");
    	
    }
}
