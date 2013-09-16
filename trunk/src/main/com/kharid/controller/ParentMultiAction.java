package com.kharid.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ParentMultiAction extends MultiActionController{
	BindingResult errors; //Declaring errors as instance variable to catch error
	Log log = LogFactory.getLog(ParentMultiAction.class);
	
	@Override
	protected void bind(HttpServletRequest request, Object command) throws Exception {
		ServletRequestDataBinder binder = createBinder(request, command);
		binder.bind(request);
		errors = binder.getBindingResult();
	}

}
