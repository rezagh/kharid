package com.kharid.controller;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.kharid.vo.InquiryVO;
import com.reza.mail.MailManager;

@Controller
public class InquiryController extends ParentMultiAction{
	private static final Log log = LogFactory.getLog(InquiryController.class);
	private MailManager mailMan;
	

	public ModelAndView sendInquiry(HttpServletRequest request, HttpServletResponse response, InquiryVO inquiry) throws Exception {
		
		inquiry.setEmail(inquiry.getEmail());
		inquiry.setName(inquiry.getName());
		if(StringUtils.isEmpty(inquiry.getEmail())) return new ModelAndView("inquiry");

		if (errors.hasErrors()) {
			return  new ModelAndView("inquiry",errors.getModel());
		}
		
		String message = "New " + inquiry.getType() + " from: " + inquiry.getName() + " "+ inquiry.getEmail() + " : " + inquiry.getMessage();
		mailMan.sendEmailToDefault("Alert from kharidsaman" , message  );
		return new ModelAndView("redirect:front.htm");
    }

	public ModelAndView ccInquiry(HttpServletRequest request, HttpServletResponse response, InquiryVO inquiry) throws Exception {

		inquiry.setEmail(inquiry.getEmail());
		inquiry.setName(inquiry.getName());

		if(StringUtils.isEmpty(inquiry.getEmail())) return new ModelAndView("cc");

		String message = inquiry.getName() + " - " + inquiry.getEmail();
		mailMan.sendEmailToDefault("CC Inquiry from kharidsaman" , message  );
		return new ModelAndView("cc");
    }

	public ModelAndView submitSurvey(HttpServletRequest request, HttpServletResponse response, InquiryVO inquiry) throws Exception {
		
		String message = "";
		
		Iterator it = request.getParameterMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String,String[]> pairs = (Map.Entry)it.next();
			String value[] = (String[])pairs.getValue();
				message = message + pairs.getKey() + " = " +  value[0] +"\n";
		}

		mailMan.sendEmailToDefault("Survey filled - kharidsaman" , message  );
		return new ModelAndView("thankyou");
    }
	
	public void setMailMan(MailManager mailMan) {
		this.mailMan = mailMan;
	}
}
