package com.kharid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//import com.notes.web.controller.NoterService;

public class FrontController implements Controller 
{
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("index");
    }
}
