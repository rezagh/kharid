package com.kharid.test;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.kharid.biz.ExchangeBiz;
import com.kharid.exchange.InterbankExchange;

public class InterbankTest {
	
	ExchangeBiz exchange;
	
	@Before
	public void setup(){
		//super.setup();
		//exchange = (ExchangeBiz) getBean("exchangeBiz");
	}
	
	@Test
	public void test() {
		InterbankExchange inter = new InterbankExchange();
		Map d = inter.getExchangeRates();
		System.out.println(d);
		//System.out.println(out);
		
	}
	
}
