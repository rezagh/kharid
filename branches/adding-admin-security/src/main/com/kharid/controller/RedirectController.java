package com.kharid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RedirectController implements Controller {
	private static final Log log = LogFactory.getLog(RedirectController.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		String dest = request.getParameter("pageId");
    	//TODO handle the unknown pages
		//log.debug("Redirecting to : " + dest);
		return new ModelAndView(dest);
	}

}
