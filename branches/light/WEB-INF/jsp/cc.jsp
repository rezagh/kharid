<%@ page contentType="text/html;charset=UTF-8" %>

<head>

</head>

<!-- <body onload="ss();">  -->

 

<!-- 
<br/>
<b>
Visa کارت 


<img src="img/visa_logo_3.gif"/>
</b>
<br/>
کارت های ویزا تنها به 3 نوع زیر موجود است 
<p align="center">

				<table border="1" style="font-size: small" id="cc_table">
					<tr>
						<td align="center">نوع</td>
						<td align="center">اعتبار کارت ($امریکا)</td>
						<td align="center">$استرالیا</td>
								
						<td align="center">قیمت - تومان</td>
						<td align="center">قیمت کارت فیزیکی + هزینه پست</td>
					</tr>
				</table>
</p>

 -->
 



<b>
نکاتی که باید بدانید
</b>

			<ul style="font-size: small;">
				<li>با داشتن شماره‌ی این کارت ها میتوانید آنلاین یا تلفنی خرید کنید و داشتن کارت فیزیکی به شما کمک میکند که از فروشگاه هایی که کارت اعتباری قبول میکنند خرید نمائد</li>
				<li>کارت غیر قابل شارژ است یعنی بعد از اتمام مبلغ آن باید کارت دیگری تهیه کنید</li>
				<li>ارز کارتها دلار استرالیاست و در خریدهای با ارز دیگر ممکن است 2.5% کارمزد کسر شود. پس لازم است هنگام سفارش کارت این به این موضوع دقت کنید</li>
				<li>درصورتی که نیاز به کارت فیزیکی ندارید لازم نیست قیمت کارت فیزیکی را بپردازید و ما مشخصات کارت را برایتان ایمیل میکنیم</li>
				<li>در صورتی که نیاز به کارت فیزیکی دارید باید قیمت کارت فیزیکی را بپردازید و ما آنرا به آدرس شما پست میکنیم</li>
				<li>موجودی کارت را میتوانید آنلاین چک کنید و لینک آن برای شما فرستاده میشود. ممکن است موجودی و لیست حساب شما با 2 تا 4 روز تاخیر دیده شود</li>
				<li>۲۴ ساعت بعد از پرداخت هزینه، کارت شما فعال است و مشخصات آن برایتان ایمیل میشود</li>
				<li>با این کارت نمیتوانید از ATM پول نقد بگیرید </li>
				<li>اعتبار این کارت یک تا دو سال است</li>
				<li>این کارت ها بدون نام هستند و به شخص یا آدرس خاصی ارتباط ندارند. به عبارت دیگر میتوانید به راحتی از اسم و آدرس خودتان استفاده کنید
				</li>
				<li>اکثر سایت های که کارت اعتباری قبول میکنند ممکن است آدرس های پستی ایرانی را قبول نکنند و لازم است از یک آدرس خارجی به عنوان آدرس کارت استفاده کنید</li>
				<li>به کمک این کارت ها و یک آدرس خارجی میتوانید در Paypal ثبت نام کرده و خرید کنید</li>
				<li>دقت کنید که IP ،Paypal   های ایران را شناسای میکند مگر اینکه از پراکسی استفاده کنید!</li>
				<li>خرید سامان مسولیتی در قبال سایت هایی که این نوع کارتها را قبول نمیکنند نمیپذیرد و کارت فروخته شده پس گرفته نمیشود.</li>
			</ul>

<br/>
<b>
خرید
</b>
<p style="font-size: small">
نام و ایمیل خود را در زیر وارد کرده تا نحوه پرداخت به شما ایمیل شود. بلافاصله بعد از دربافت هزینه، شماره کارت برای شما ایمیل میشود و یا کارت پست میگردد
</p>

	<form:form method="post" name="inquiryController" action="inquiry.htm?method=ccInquiry">
		<table style="font-size: small">
			<tr>
				<td>نام</td>
				<td>
						<input name="name"/>		
				</td>
			</tr>
			<tr>
				<td>ایمیل</td>
				
				<td>
				<input name="email"/>				
				</td>
			</tr>
		
			<tr>
				<td><input  type="submit" class="btn" onclick="this.disabled=true; alert('ارسال شد');"  value="ارسال"/></td>
			</tr>
		</table>
	</form:form>


