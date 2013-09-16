<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<table border="1">
	<tr>
		<td align="center"><b>نام</b></td>
		<td align="center"><b>نام انگلیسی</b></td>		
		<td align="center"><b>مشخصه</b></td>
		<td align="center"><b>زمان تحویل - روز</b></td>
		<td align="center"><b>حداکثر وزن - کیلو</b></td>
	</tr>

	<c:forEach var="p" items="${postTypes}">
		<tr>
			<td><c:out value="${p.farsiName}"></c:out> </td>	
			<td align="left"><c:out value="${p.engName}"></c:out> </td>
			<td><c:out value="${p.desc}"></c:out> </td>
			<td align="center"><c:out value="${p.deliveryTime}"></c:out> </td>
			<td align="center"><c:out value="${p.maxWeightAllowed}"></c:out> </td>
	    </tr>
	</c:forEach>
</table>

	<div style="float: right;">
		<ul>
			<li>
			هزینه بسته بندی بین یک تا پنج هزار تومان میباشد.
			</li>
		</ul>
	</div>





<div style="float: right;">

موارد زیر توسط پست ایران ممنوعه حساب میشوند و نمیتوان آنها را پست کرد:
<ul>
	<li>هر گونه کالایی که خلاف موازین اسلامی است</li>
	<li>اسلحه</li>
	<li>دارو</li>
	<li>حشرات و حشره کش</li>
	<li>وسایل عکاسی</li>
	<li>ساخارین</li>
	<li>الکل و مشتقات آن</li>
	<li>محصولات حیوانی</li>
	<li>طلا و نقره</li>
	<li>بلیط های بخت آزمایی</li>
	<li>پول</li>
	<li>خوراکی های فاسد شدنی</li>
	<li>گیاه</li>
	<li>شکر</li>
	<li>وسایل بیسیم</li>
	<li>تنباکو</li>
	<li>سیستم های رادیویی</li>
	<li>مواد سمی</li>

</ul>

امکان دارد قوانین مربوط به بعضی از موارد پستی تغییر کنند. برای اطمینان از دریافت کالای خود قبلا با ما مشورت کنید. 
اطلاعات دقیقتر  را  <a href="http://auspost.com.au/apps/international-post-guide.html?countryCode=IR" style="text-decoration:underline;font-weight: bold" target="_blank">اینجا</a> ببینید 



</div>

