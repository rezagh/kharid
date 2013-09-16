<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.kharid.model.type.PostTypeEnum"%>

<head>
	<script>
		function changesForNonPhysical() {
			document.getElementById("total").style.display='block'; //for div
			document.getElementById("post_table").style.display='none';
			document.getElementById("post_to_aus").disabled=true;
			document.getElementById("weight").disabled=true;
			document.getElementById("weight_unit").disabled=true;
			document.getElementById("to_aus_currency").disabled=true;
			document.getElementById("package_type").disabled=true;
			
		}

		function changesForPhysical() {
			document.getElementById("total").style.display = 'none'; //for div
			document.getElementById("post_table").style.display='block';
			document.getElementById("post_to_aus").disabled=false;
			document.getElementById("weight").disabled=false;
			document.getElementById("weight_unit").disabled=false;
			document.getElementById("to_aus_currency").disabled=false;		
			document.getElementById("package_type").disabled=false;

		}

		function calculateFinalPrice() {
			
			if (document.getElementById("price").value == '') {
				 alert('لطفا قیمت را وارد کنید');
				 return;
			}
			

//			if (document.getElementsByName("group1")[0].checked && document.getElementById("post_to_aus").value == '') {
//				 alert('لطفا هزینه پست تا استرالیا را وارد کنید') ;
//				 return;
//			}
			
			if (document.getElementsByName("group1")[0].checked && document.getElementById("weight").value == '') {
				 alert('لطفا وزن را وارد کنید') ;
				 return;
			}

//			if (document.getElementsByName("group1")[0].checked && 	document.getElementById("postage_type").value == '') {
//				 alert('لطفا نوع پست را وارد کنید'); 
//				 return;
//			}
				
			var goodTypeVar;


			if(document.getElementsByName("group1")[0].checked){

				goodTypeVar='PHYSICAL';

				var pricevo = { goodType: goodTypeVar,
						basePrice:document.getElementById("price").value, 
						basePriceUnit:document.getElementById("currency").value, 
						weight:document.getElementById("weight").value, 
						weightUnit:document.getElementById("weight_unit").value,
						priceToAus:document.getElementById("post_to_aus").value,
						priceToAusUnit:document.getElementById("to_aus_currency").value,
						packageType:document.getElementById("package_type").value
					  };

				  DwrManager.calculateFinalPrice(pricevo,function(items) {
					  document.getElementById('AIR').innerHTML=items['AIR'];
					  document.getElementById('ECI').innerHTML=items['ECI'];
					  document.getElementById('EPI').innerHTML=items['EPI'];
					  document.getElementById('SEA').innerHTML=items['SEA'];
					  document.getElementById('REG').innerHTML=items['REG'];
				  });
				 
			}
			if(document.getElementsByName("group1")[1].checked){

				goodTypeVar='NON_PHYSICAL';

				var pricevo = { goodType: goodTypeVar,
						basePrice:document.getElementById("price").value, 
						basePriceUnit:document.getElementById("currency").value, 
						weight:document.getElementById("weight").value, 
						weightUnit:document.getElementById("weight_unit").value,
						priceToAus:document.getElementById("post_to_aus").value,
						priceToAusUnit:document.getElementById("to_aus_currency").value
					  };

				  DwrManager.calculateFinalPriceNonPhysical(pricevo,function(item) {
					  document.getElementById('total_input').value=item;
				  });
				 
			}
		}

	
//		function calculateCommission(){
//			var pr= document.getElementById("price").value;
//			var curr = document.getElementById("currency").value;

//			DwrManager.calculateCommission(pr,curr,	function(item) {
				
//				 document.getElementById("commission").value = item;
//				 });
//		}
		
		function disableme(element_id){
			document.getElementById(element_id).disabled = true; 
		}

//		function calculatePostPriceToIran(){
//			DwrManager.getPostagePriceToIran(document.getElementById("weight").value,
//											document.getElementById("weight_unit").value,
//											document.getElementById("postage_type").value,
//						function(item) {
//				 			document.getElementById("post_to_iran").value = item;
//			});
//		}
	</script>
</head>

<div style="margin-left: auto;margin-right: auto;width: 950px;">
<%@ include file="topSection.jsp"%>
<%@ include file="rightMenu.jsp"%>


<div class="mainsection" style="direction: rtl">
	<div style="float: right;">
		<table border="1" >
		
			<tr><td>
				نوع کالا <br/>
				<input type="radio" name="group1"  value="physical" onchange="changesForPhysical();" checked="checked"> فیزیکی<br/>
				<input type="radio" name="group1"  value="non_physical" onchange="changesForNonPhysical();">غیر فیزیکی ( اعتباری یا بدون هزینه‌ی پست )<br/>
			</td></tr>
			
			<tr>
				<td>
					قیمت پایه
					<input id ="price" name="price" class="calc"/>
					<select id="currency" name="currency">
						<option value="USD">دلار امریکا</option>
						<option value="EUR">یورو</option>
						<option value="AUD">دلار استرالیا</option>
					</select>
					
				</td>
			</tr>
		
			<tr>
				<td>	
					هزینه پست تا استرالیا
					<input  id="post_to_aus" name="post_to_aus" class="calc"/>
						
						<select name="to_aus_currency" id="to_aus_currency">
							<option value="USD">دلار امریکا</option>
							<option value="EUR">یورو</option>
							<option value="AUD">دلار استرالیا</option>
						</select>
						<br/>
					<span style="font-size: small;">از آنجایی که شرکت ما در استرالیا واقع است این قیمت لازم میباشد</span>
				</td>
			</tr>
		
			
			<tr>
				<td>
					وزن تقریبی
					
					<input  name="weight" id="weight" class="calc"/>
						<select name="weight_unit" id="weight_unit">
							<option value="KG">کیلو</option>
							<option value="GRAM">گرم</option>
							<option value="POUND">پوند</option>
						</select><span style="font-size: small;"> - زیر 3 کیلو</span>
					
					<br/>
					<span style="font-size: small;">
					برای محاسبه قیمت کالاهای بیش از 3 کیلو با ما تماس بگیرید
					</span>
				</td>
			</tr>

			<tr>
				<td>
					نوع بسته بندی
					
					<select name="package_type" id="package_type">
						<option value="PARCEL">بسته پستی</option>
						<option value="LETTER">نامه - زیر ۵۰۰ گرم</option>
					</select>
				</td>
			</tr>
		
			<tr><td align="center">	
				
				<input id="btn" name="" type="submit"  onclick="calculateFinalPrice();" value="محاسبه قیمت کل تا ایران"/>
				
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

	<div style="clear:both">
		<ul>
			<li>
				این قیمت تقریبی است و کارمزد نیز در آن محاسبه شده اما برای محاسبه 
				قیمت دقیق و بروز باید با ما تماس بگیرید		
			</li>
			<li>
			هزینه بسته بندی بین یک تا پنج هزار تومان میباشد.
			</li>
		</ul>
	</div>
</div>
</div>

<%@ include file="buttomSection.jsp"%>