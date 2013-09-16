<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="css/main.css" rel="stylesheet" type="text/css" />

<html>

	<head>
		<title>Kharid Saman - خرید آنلاین</title>
		<meta name="description"
			content="kharid saman, خرید سامان , خرید آنلاین بدون کارت اعتباری , فروش کارت اعتباری , خرید های خارجی , online shopping in iran without credit card, kharid online, ebay, amazon, kharidsaman " />
		<link rel="icon" type="image/ico" href="favicon.ico"></link>
	</head>
	
	<!-- ClickDesk Live Chat Service for websites -->
<script type='text/javascript'>
var _glc =_glc || []; _glc.push('all_ag9zfmNsaWNrZGVza2NoYXRyDgsSBXVzZXJzGLH3qAwM');
var glcpath = (('https:' == document.location.protocol) ? 'https://my.clickdesk.com/clickdesk-ui/browser/' : 
'http://my.clickdesk.com/clickdesk-ui/browser/');
var glcp = (('https:' == document.location.protocol) ? 'https://' : 'http://');
var glcspt = document.createElement('script'); glcspt.type = 'text/javascript'; 
glcspt.async = true; glcspt.src = glcpath + 'livechat-new.js';
var s = document.getElementsByTagName('script')[0];s.parentNode.insertBefore(glcspt, s);
</script>
<!-- End of ClickDesk -->

	
	<body dir="rtl">
		<div style="margin-left: auto; margin-right: auto; width: 950px;">
	
			<div style="padding: 1; direction: rtl">
				<tiles:insertAttribute	name="header" />
			</div>
	
			<div style="float: right; padding-left: 5; padding-top: 5">
				<tiles:insertAttribute	name="rightColumn" />
			</div>
			
			<div style="float: right; padding-left: 5; padding-top: 5; direction: rtl;">
				<div class="mainsection" style="direction: rtl">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
			
			<div style="clear: both" align="center"><tiles:insertAttribute	name="footer" /></div>
			
		</div>
	</body>

</html>