<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<div style="margin-left: auto;margin-right: auto;width: 950px;">
<%@ include file="topSection.jsp"%>
<%@ include file="rightMenu.jsp"%>



<div class="mainsection" style="direction: rtl">

	<form:form method="post" name="inquiryController" action="inquiry.htm?method=sendInquiry">
		<table>
				<tr>
					<td>نام</td>
					<td><input name="name" class="css"/></td>
				</tr>
				<tr>
					<td>ایمیل</td>
					<td><input name="email" class="css"/></td>
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
				<td><input  type="submit" class="btn" onclick="this.disabled=true;alert('ارسال شد');"  value="ارسال"/></td>
			</tr>
		</table>
	</form:form>

</div>
<%@ include file="buttomSection.jsp"%>
</div>
