package com.kharid.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansUtil {
	ApplicationContext context;
	
	
	public void getBean(){
		context = new ClassPathXmlApplicationContext("../spring-config.xml");
		Object o = context.getBean("mailMan");
		System.out.println();
	}
}
