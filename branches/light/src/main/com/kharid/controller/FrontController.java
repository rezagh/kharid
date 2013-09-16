package com.kharid.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kharid.model.type.PostTypeEnum;

@Controller
public class FrontController 
{
	@RequestMapping("/front.htm")
	public ModelAndView handleRequest() {
		return new ModelAndView("index");
    }
	
	@RequestMapping("/calculator.htm")
	public ModelAndView showCalculator(){
		return new ModelAndView("calculator");
    }

	@RequestMapping("/book.htm")
	public ModelAndView showBooksPage(){
		return new ModelAndView("book");
    }

	@RequestMapping("/goods.htm")
	public ModelAndView showGoodsPage(){
		return new ModelAndView("goods");
    }

	@RequestMapping("/cc.htm")
	public ModelAndView showCcPage(){
		return new ModelAndView("cc");
    }

	@RequestMapping("/payments.htm")
	public ModelAndView showPaymentsPage(){
		return new ModelAndView("payments");
    }

	@RequestMapping("/faq.htm")
	public ModelAndView showFaqPage(){
		return new ModelAndView("faq");
    }

	@RequestMapping("/postage.htm")
	public ModelAndView showPostagePage(){
		Map map = new HashMap();
		map.put("postTypes", PostTypeEnum.values());
		return new ModelAndView("postage",map);
    }

	@RequestMapping("/eng.htm")
	public ModelAndView showEngPage(){
		return new ModelAndView("eng");
    }

	
	@RequestMapping("/inquiry.htm")
	public ModelAndView listInquiryPage() {
		return new ModelAndView("inquiry");
    }
}
 	