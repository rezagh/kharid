<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!--  
<form:form method="post" name="inquiryController" action="inquiryController.htm?method=sendInquiry">
	<table>
			<tr>
				<td>نام</td>
				<td><input name="name" class="css"/></td>
			</tr>
			<tr>
				<td>ایمیل</td>
				<td><input name="email" class="css" required="required"/></td>
			</tr>
	
		<tr>
			<td>موضوع</td>
			<td>
				<select name="type" class="css">
					<c:forEach var="e" items="${inquiryTypes}">
						<option value="<c:out value="${e}"/>"><c:out value="${e.farsiValue}"/></option>
					</c:forEach>	
				</select>
			</td>
		</tr>
		<tr>
			<td>پیام یا لینک کالا</td>
			<td>
				<textarea rows="6" cols="50" class="css" name="message"></textarea><form:errors path="message"/>			
			</td>
		</tr>
	
		<tr>
			<td><input  type="submit" class="btn"  value="ارسال"/></td>
		</tr>
	</table>	
		

	
</form:form>
-->

<br/>

<table border="1" cellpadding="5">

		<tr>
				<td nowrap>
		تلفن های تماس
				</td>
				<td>
				ایران: 09121076711 فقط جهت هماهنگی پستی و ارسال کالا <br/> استرالیا: 0061402636492 جهت کلیه امور خرید و پرداخت <br/>(لطفآ حداقل 6 ساعت  زمان جلوتر را در نظر داشته باشید )
				</td>
		
		</tr>
		<tr>
				<td nowrap>
		ایمیل
				</td>
				<td>
				<a href="mailto:info@kharidsaman.com">info@kharidsaman.com</a> 
				
			
				</td>
		
		</tr>

</table>