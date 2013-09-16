<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<link href="css/main.css" rel="stylesheet" type="text/css" />

<body dir="rtl">
	<%@ include file="topSection.jsp" %>
	<br/>

	<div align="center">
		<form method="post" name="inquiryController" action="inquiry.htm?method=sendInquiry">
	
			
			<input type="hidden" name="type" value="CONSTRUCTION_NOTIFY" /> 
			<input type="hidden" name="message" value="<%=request.getParameter("message")%>" /> <br/>
			<input type="submit" class="btn"  value="<fmt:message key="send"/>" />
		</form>
	</div>
	<%@ include file="buttomSection.jsp" %>

</body>
</html>