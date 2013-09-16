<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.kharid.model.type.PostTypeEnum"%>

<div style="margin-left: auto;margin-right: auto;width: 950px;">
<%@ include file="topSection.jsp"%>
<%@ include file="rightMenu.jsp"%>

<div class="mainsection" style="direction: rtl">
<table border="1">
	<tr>
		<td align="center"><b>نام</b></td>
		<td align="center"><b>نام انگلیسی</b></td>		
		<td align="center"><b>مشخصه</b></td>
		<td align="center"><b>زمان تحویل - روز</b></td>
		<td align="center"><b>حداکثر وزن - کیلو</b></td>
	</tr>

	<c:forEach var="p" items="<%=PostTypeEnum.values()%>">
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
			هزینه بسته بندی از استرالیا بین یک تا پنج هزار تومان میباشد.
			</li>
			<li>
			تفاوت بین پستها را <a style="text-decoration:underline;" href="redirect.htm?pageId=postage">اینجا</a> مشاهده کنید
			</li>
			<li>
					<a style="text-decoration:underline;" href="redirect.htm?pageId=calculator">محاسبه قیمت تقریبی</a>
			</li>
			<li>
					<a style="text-decoration:underline;" href="redirect.htm?pageId=prohibited">قوانین پستی</a>
			</li>

		</ul>
	</div>

</div>



<%@ include file="buttomSection.jsp"%>


</div>

