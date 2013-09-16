<%@ include file="header.jsp"%>

<script>
$(document).ready(function() {
	  DwrManager.getExchange(function(items) {
		  document.getElementById('usd').innerHTML=items['USD_TO_IRR_RATE'];
		  document.getElementById('aud').innerHTML=items['AUD_TO_IRR_RATE'];
		  document.getElementById('gbp').innerHTML=items['GBP_TO_IRR_RATE'];
		  document.getElementById('eur').innerHTML=items['EUR_TO_IRR_RATE'];
	  });
	});
</script>



<%@ page contentType="text/html;charset=UTF-8" %>


<div class="rightmenu"> 
	<div style="background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<img src="img/bullet.gif"/><b> <a href="redirect.htm?pageId=faq">سوال و جوابهای متداول</a></b><br/>
	</div>
	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<img src="img/bullet.gif"/><b> <a href="redirect.htm?pageId=calculator">محاسبه قیمت تقریبی</a></b><br/>
	</div>
	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<img src="img/bullet.gif"/><b> <a href="redirect.htm?pageId=cc">فروش کارت اعتباری</a></b><br/>
	</div>

	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<img src="img/bullet.gif"/><b> <a href="redirect.htm?pageId=postage">پست و بسته بندی</a></b><br/>
	</div>
	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<img src="img/bullet.gif"/><b> <a href="redirect.htm?pageId=prohibited">قوانین پستی ایران</a></b><br/>
	</div>


	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<img src="img/bullet.gif"/> 
		<!-- see google chatback http://www.google.com/talk/service/badge/New -->
		<b><img style="padding: 0pt 2px 0pt 0pt; margin: 0pt; border: medium none;" src="http://www.google.com/talk/service/resources/chaticon.gif" alt="" width="16" height="14"><img style="padding: 0pt 2px 0pt 0pt; margin: 0pt; border: medium none;" src="http://www.google.com/talk/service/badge/Show?tk=z01q6amlqcpg2qigr24rfb8ui37en3d7nvfkk0vt1q69c7ha2cs3l0gu2mr4nr9kr7dupvielahtfslev3m5gfa4arqu92q4pe05kdkur4pf362jfr31jmc66dp1quvksmcqf2k6f043umi5u48rcpr6hudoegkpcbctju3cp6kdrs0q8v5vt2qk80s9jtj21ro&amp;w=9&amp;h=9" alt="" width="9" height="9"><a href="http://www.google.com/talk/service/badge/Start?tk=z01q6amlqcpg2qigr24rfb8ui37en3d7nvfkk0vt1q69c7ha2cs3l0gu2mr4nr9kr7dupvielahtfslev3m5gfa4arqu92q4pe05kdkur4pf362jfr31jmc66dp1quvksmcqf2k6f043umi5u48rcpr6hudoegkpcbctju3cp6kdrs0q8v5vt2qk80s9jtj21ro" target="_blank" title="Click here to chat with Customer Service"> چت آنلاین با مدیر </a></b>
		<br/>
	</div>

	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<b><img src="img/bullet.gif"/> نرخ ارز خرید سامان:</b><br/>
	</div>

	<div style="background: #D4CAB6;padding-right: 7px;font-size: small;padding-bottom: 5px">
		دلار امریکا <span id="usd" style="direction:ltr; font-size: x-small;"></span><br/>
		دلار استرالیا <span id="aud" style="direction:ltr; font-size: x-small;"></span><br/> 
		پوند انگلیس <span id="gbp" style="direction:ltr; font-size: x-small;"></span><br/>
		یورو <span id="eur" style="direction:ltr; font-size: x-small;"></span> 
	</div>

	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 20px;padding-top: 5px;">
		<b><img src="img/bullet.gif"/> <a target="_blank" href="redirect.htm?pageId=mesghal">نرخ ارز در بازار</a><br/></b>
		
	</div>
	


<!-- 
<img src="img/twitter.png" height="40" width="40"/>
 -->
 
 
	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;height: 50px;padding-top: 1px;">
		<p align="center" style="margin-top: 2px">
			 <a target="_blank" href="http://www.facebook.com/pages/khryd-saman-Kharid-Saman/131742383536378"><img src="img/5u84f48n.gif" height="44" width="144" style="border-style: none"/></a>
		</p>
	</div>



	<div style="margin-top: 1px;background: #D4CAB6;font-size: small;padding-top: 5px;padding-bottom: 5px;">
		<img src="img/bullet.gif"/><a href="http://www.iranianozi.com" target="_blank"/> تبلیغات ایرانیان استرالیا</a><br/>
		
		
	</div>

</div>