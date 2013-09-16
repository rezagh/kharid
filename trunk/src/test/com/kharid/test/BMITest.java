package com.kharid.test;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.kharid.biz.ExchangeBiz;
import com.kharid.exchange.BMIExchange;

public class BMITest extends  BaseTest {
	
	ExchangeBiz exchange;
	
	@Before
	public void setup(){
		super.setup();
		exchange = (ExchangeBiz) getBean("exchangeBiz");
	}
	@Test
	public void test(){
		//BMIExchange bmi = new
		
		Map<String,Double> map = exchange.getExchangeRates();
		System.out.println(map);
	}
	
	@Test
	public void getExchangeRateEn() {
		BMIExchange bmi = new BMIExchange();
		//public Double getExchangeRateEn(String exchangeString,CurrencyTypeEnum currency) {
		String exchangeString = 
				" <title>Currency Rates at 2010/03/31</title>    <description>Currency Rates </description>  " +
				"  <link>http://www.bmi.ir/Fa/curr.aspx</link>    <image>      <title>Iran Melli Bank Rss</title>  " +
				"    <url>http://www.bmi.ir/App_Themes/Fa/images/SiteIcon/BMILogo.gif</url>      <link>http://www.bmi.ir/</link>   " +
				"   <description>Iran Melli Bank Rss</description>      <width>100</width>      <height>30</height>    </image>  " +
				"  <copyright>(c) 2005, BankMelli  Web Site. All rights reserved.</copyright>    <webMaster>BMI WebSite</webMaster>" +
				"    <pubDate>Thu, 01 Apr 2010 13:15:55 GMT</pubDate>    <lastBuildDate>2010/04/01</lastBuildDate>   " +
				" <category>Iran Melli Bank</category>    <category>Currency Rate</category>    <generator>http://www.bmi.ir</generator>   " +
				" <item>      <title>EUR</title>      <description>Buy (Rls) : 13411 &lt;BR&gt; Sale (Rls) : 13456 &lt;BR&gt; Ref (Rls) : " +
				"0</description>      <link>http://www.bmi.ir/Fa/curr.aspx?y=2010&amp;m=3&amp;d=31&amp;</link>     " +
				" <author>2010/03/31</author>      <pubDate>Thu, 01 Apr 2010 13:15:55 GMT</pubDate>    </item>    <item> " +
				"     <title>USD</title>      <description>Buy (Rls) : 10014 &lt;BR&gt; Sale (Rls) : 10044 &lt;BR&gt; Ref (Rls) :" +
				" 0</description>      <link>http://www.bmi.ir/Fa/curr.aspx?y=2010&amp;m=3&amp;d=31&amp;</link>    " +
				"  <author>2010/03/31</author>      <pubDate>Thu, 01 Apr 2010 13:15:55 GMT</pubDate>    </item>    <item>   " +
				"   <title>GBP</title>      <description>Buy (Rls) : 15086 &lt;BR&gt; Sale (Rls) : 15141 &lt;BR&gt; Ref (Rls) " +
				": 0</description>      <link>http://www.bmi.ir/Fa/curr.aspx?y=2010&amp;m=3&amp;d=31&amp;</link>     " +
				" <author>2010/03/31</author>      <pubDate>Thu, 01 Apr 2010 13:15:55 GMT</pubDate>    </item>    <item>    " +
				"  <title>AUD</title>      <description>Buy (Rls) : 9153 &lt;BR&gt; Sale (Rls) : 9193 &lt;BR&gt; Ref (Rls)" +
				" : 0</description>      <link>http://www.bmi.ir/Fa/curr.aspx?y=2010&amp;m=3&amp;d=31&amp;</link>     " +
				" <author>2010/03/31</author>      <pubDate>Thu, 01 Apr 2010 13:15:55 GMT</pubDate>    </item>    <item>  " +
				"    <title>CAD</title>      <description>Buy (Rls) : 9824 &lt;BR&gt; Sale (Rls) : 9864 &lt;BR&gt; Ref (Rls)" +
				" : 0</description>      <link>http://www.bmi.ir/Fa/curr.aspx?";
		
		//Long out = bmi.getExchangeRateEn(exchangeString, CurrencyTypeEnum.AUD);
		//System.out.println(out);
		
	}
	
}
