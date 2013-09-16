<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.kharid.model.type.PostTypeEnum"%>

<head>
	<script type='text/javascript'>

	function changesForNonPhysical() {
			document.getElementById("total").style.display='block'; //for div
			document.getElementById("weight_div").style.display='none';
			
			document.getElementById("post_table").style.display='none';
			document.getElementById("package_row").style.display='none';
			
			document.getElementById("to_aus_row").style.display='none';
			document.getElementById("post_to_aus").disabled=true;
			document.getElementById("weight").disabled=true;
			document.getElementById("weight_unit").disabled=true;
			document.getElementById("to_aus_currency").disabled=true;
			document.getElementById("package_id").disabled=true;
			
		}

		function changesForPhysical() {
			document.getElementById("total").style.display = 'none'; //for div
			document.getElementById("weight_div").style.display='block';
			
			document.getElementById("post_table").style.display='block';
			document.getElementById("package_row").style.display='block';
			
			document.getElementById("to_aus_row").style.display='block';
			
			document.getElementById("post_to_aus").disabled=false;
			document.getElementById("weight").disabled=false;
			document.getElementById("weight_unit").disabled=false;
			document.getElementById("to_aus_currency").disabled=false;		
			document.getElementById("package_id").disabled=false;

		}

		function calculateFinalPrice() {
			
			if (document.getElementById("price").value == '') {
				 alert('لطفا قیمت را وارد کنید');
				 return;
			}

			if (document.getElementById("rate").value == '') {
				 alert('لطفآ نرخ تبدیل دلار استرالیا را وارد کنید');
				 return;
			}

			if (document.getElementsByName("group1")[1].checked && document.getElementById("weight").value == '') {
				 alert('لطفا وزن را وارد کنید') ;
				 return;
			}

			
			//physical
			if(document.getElementsByName("group1")[1].checked){
				
				var pricevo = {
						basePrice:document.getElementById("price").value,
						basePriceUnit:document.getElementById("currency").value, 
						weight:document.getElementById("weight").value, 
						audIrrRate:document.getElementById("rate").value,
						weightUnit:document.getElementById("weight_unit").value,
					  };

				  DwrManager.calculateFinalPrice(pricevo,function(items) {
					  document.getElementById('AIR').innerHTML=items['AIR'];
					  document.getElementById('EPI').innerHTML=items['EPI'];
					  document.getElementById('SEA').innerHTML=items['SEA'];
					  document.getElementById('REG').innerHTML=items['REG'];
				  });
				  
			}
			
			//non physical
			if(document.getElementsByName("group1")[0].checked){
				
				var pricevo = {
						basePrice:document.getElementById("price").value,
						basePriceUnit:document.getElementById("currency").value, 
						audIrrRate:document.getElementById("rate").value,
					  };

				
				DwrManager.calculateFinalPrice(pricevo,function(item) {
					
					document.getElementById('total_input').value=item['nopost'];
				  });
			}
				 
		}

	
		function disableme(element_id){
			document.getElementById(element_id).disabled = true; 
		}

		</script>
</head>






	

	<div style="float: right;clear:both;">
		<table border="1">
		
			<tr>
				<td>
					قیمت 
					<input id ="price" name="price" class="calc"/>
					<select id="currency" name="currency">
						<option value="USD">دلار امریکا</option>
						<option value="EUR">یورو</option>
						<option value="AUD">دلار استرالیا</option>
						<option value="GBP">پوند</option>
					</select>
					- 
					
					نرخ دلاراسترالیا 
					<input id ="rate" name="rate" class="calc"/> تومان
						<span style="font-size: xx-small;">(از این جهت لازم است که ارز پرداختی شرکت دلار استرالیا است)</span>
					
				</td>
			</tr>
		
			<tr >
				<td id="weight_row">
				
				<input type="radio" name="group1"  value="non_physical" onchange="changesForNonPhysical();">غیر فیزیکی ( اعتباری یا بدون هزینه پست )<br/>
				<input type="radio" name="group1"  value="physical" onchange="changesForPhysical();" checked="checked"> فیزیکی<br/>
					
					
					<div id="weight_div" style="padding-right: 30px;">
					وزن تقریبی
						<input  name="weight" id="weight" class="calc"/>
							<select name="weight_unit" id="weight_unit">
								<option value="GRAM">گرم</option>
								<option value="KG">کیلو</option>
								<option value="POUND">پوند</option>
							</select><span style="font-size: small;"> - زیر 3 کیلو</span>
	
						<span style="font-size: xx-small;">(برای محاسبه قیمت کالاهای بیش از 3 کیلو با ما تماس بگیرید)
						</span>
					</div>
				</td>
				
			</tr>

	
			<tr><td align="center">	
				
				<input id="btn" name="" type="submit"  onclick="calculateFinalPrice();" value="محاسبه قیمت تقریبی"/>
				
			</td></tr>
		
			<tr><td>	
				<table border="1" style="font-size: small" id="post_table">
					<tr>
						<td align="center">نام</td>
						<td align="center">مشخصه</td>
						<td align="center">زمان تحویل - روز</td>
						<td align="center">حداکثر وزن - کیلو</td>
						<td align="center">قیمت کل - تومان</td>
					</tr>
	
					<c:forEach var="p" items="<%=PostTypeEnum.values()%>">
						<tr>
							<td nowrap="nowrap">
								<c:out value="${p.farsiName}"></c:out>	<br/>
								<div align="left" style="font-size: x-small"><c:out value="${p.engName}"></c:out></div>
							</td>	
							
							<td><c:out value="${p.desc}"></c:out> </td>
							<td align="center"><c:out value="${p.deliveryTime}"></c:out> </td>
							<td align="center"><c:out value="${p.maxWeightAllowed}"></c:out> </td>
							<td align="center"><span id="${p}"></span> </td>
					    </tr>
					</c:forEach>
				</table>
				
				<div id="total" align="center" style="display: none;"> <!-- becomes visibile by js -->
					<input  name="total" id="total_input" class="farsi" disabled="disabled" /> تومان			
				</div>

			</td></tr>
		</table>
	</div>

	<div style="float: right;clear:both;width: 100%">
		<table width="100%">
		<tr><td></td></tr>
		</table>
	<hr width="100%"/>
	</div>

	<div style="float: right;clear:both;">
<b>کارمزد با توجه به جدول زیر محاسبه میشود :</b> 
		 
		<table border="1" style="margin-top: 10px; margin-bottom: 10px">
			<tr> 
				<td>
قیمت به ارز خارجی (دلار، یورو، ...)			
				</td>
				<td>
				۱-۱۰۰ 
				</td>
				<td>
				۱۰۱-۲۵۰ 
				</td>
				<td>
				۲۵۱-۵۰۰ 
				</td>
				<td>
				۵۰۱-۱۰۰۰ 
				</td>
				<td>
۱۰۰۰ به بالا
				</td>
			</tr>
			<tr> 
				<td>
				درصد کارمزد
				</td>
				<td>
				۲۴ ٪(و حداقل ۵ دلار)
				</td>
				<td>
۱۹ ٪
				</td>
				<td>
	۱۷ ٪
				</td>
				<td>
				۱۴ ٪
				</td>
				<td>
				۱۲ ٪
				</td>

			</tr>

		</table>
	</div>	

	<div style="clear:both">
		<ul>
			<li>
				این قیمت تقریبی است که هزینه بسته بندی و کارمزد نیز در آن محاسبه شده اما برای محاسبه 
				قیمت دقیق و بروز باید با ما تماس بگیرید		
			</li>
		</ul>
	</div>

	
	
