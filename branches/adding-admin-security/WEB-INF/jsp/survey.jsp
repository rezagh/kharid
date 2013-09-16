<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
 
<script language="javascript" type="text/javascript"> 
	function sendEmail(){
	   document.getElementById("btn").disabled=true;
	   document.getElementById("btn").value="صبر کنید";
		var url= document.location.href;
		url = url.substring(url.indexOf("email"));
		document.getElementById("email").value = url;
		document.myform.submit();
	}
</script> 

 <div style="margin-left: auto;margin-right: auto;width: 950px;">
<%@ include file="topSection.jsp"%>
<%@ include file="rightMenu.jsp"%>

<!-- 
http://localhost:8080/kharid/redirect.htm?pageId=survey&email=rezaghp@gmail.com
 -->

<div class="mainsection" style="direction: rtl">

<p style="font-weight: bold" align="center">
فرم نظر خواهی (اختیاری) 
</p>


<form:form action="inquiry.htm?method=submitSurvey" name="myform">
نام <input name="name"/>
ایمیل <input dir="ltr" name="email"/>
<br/>
<p style="font-weight: bold">کارمزد 30%</p>
			<input type="radio" name="commission30p" value="high">زیاد است<br/> 
			<input type="radio" name="commission30p" value="low">کم است<br/>
			<input type="radio" name="commission30p" value="ok">مناسب است<br/>

<p style="font-weight: bold">کارمزد 25%</p>
			<input type="radio" name="commission25p" value="high">زیاد است<br/> 
			<input type="radio" name="commission25p" value="low">کم است<br/>
			<input type="radio" name="commission25p" value="ok">مناسب است<br/>


<p style="font-weight: bold">کارمزد 20%</p>
			<input type="radio" name="commission20p" value="high">زیاد است<br/> 
			<input type="radio" name="commission20p" value="low">کم است<br/>
			<input type="radio" name="commission20p" value="ok">مناسب است<br/>


<p style="font-weight: bold">هزینه‌ی پست</p>
			<input type="radio" name="postcost" value="high">زیاد است <br/>
			<input type="radio" name="postcost" value="low">کم است<br/>
			<input type="radio" name="postcost" value="ok">مناسب است<br/>


<p style="font-weight: bold">بسته بندی</p>
			<input type="radio" name="packaging" value="ok"/>مناسب بوده<br/>
			<input type="radio" name="packaging" value="can be better"/>میتواند بهتر باشد<br/>

<p style="font-weight: bold">مکاتبات شما با خرید سامان</p>
			<input type="radio" name="correspondence" value="fast and accurate"/>به سرعت و با دقت پاسخ داد شده<br/>
			<input type="radio" name="correspondence" value="late response"/>دیر جواب داده شده<br/> 
			<input type="radio" name="correspondence" value="inaccurate"/>بدون دقت پاسخ داد شده<br/>
			<input type="radio" name="correspondence" value="late and inaccurate"/>بدون دقت و دیر پاسخ داد شده<br/>

<p style="font-weight: bold">تجربه‌ی کلی شما با خرید سامان </p>
			<input type="radio" name="totalexp" value="satisfactory"/>رضایت بخش بوده<br/> 
			<input type="radio" name="totalexp" value="average"/>معمولی بوده<br/> 
			<input type="radio" name="totalexp" value="not good"/>خوب نبوده<br/> 

<p style="font-weight: bold">آیا خرید سامان را به دیگران پیشنهاد  میکنید</p>
			<input type="radio" name="suggestit" value="yes"/>بله<br/>
			<input type="radio" name="suggestit" value="no"/>نه<br/>
			<input type="radio" name="suggestit" value="maybe"/>شاید<br/>
<p style="font-weight: bold">توضیح یا پیشنهادات</p>
	<textarea rows="6" cols="50" class="css" name="desc"></textarea>
	<br/>
	<input type="submit" id="btn" value="ارسال" onclick="sendEmail();"/> 
</form:form>

<ul>
	<li>نظر و اطلاعات شخصی شما نزد ما محفوظ است</li>
	<li>ممکن است از نظرات شما بدون ذکر نام در سایت استفاده کنیم</li>
</ul>

</div>
<%@ include file="buttomSection.jsp"%>
</div>
 