package com.kharid.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BaseTest {
	public BeanFactory factory;
	ApplicationContext applicationContext;
	
	
	public void setup() {
		//applicationContext = new ClassPathXmlApplicationContext(new String[]{"WEB-INF/spring-config.xml"});
		//Resource xmlResource = new FileSystemResource("WEB-INF/spring-config.xml");
		applicationContext = new FileSystemXmlApplicationContext(new String[]{"WEB-INF/test-spring-conf.xml"});
        //factory = new XmlBeanFactory(xmlResource);
        //Employee employeeBean = (Employee)factory.getBean("employeeBean");
	}
	
	public Object getBean(String beanName){
		return applicationContext.getBean(beanName);
		//return factory.getBean(beanName);
	}
}
