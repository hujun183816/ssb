<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String appId = request.getParameter("appid");
String timeStamp = request.getParameter("timeStamp");
String nonceStr = request.getParameter("nonceStr");
String packageValue = request.getParameter("package");
String paySign = request.getParameter("sign");
String describe = request.getParameter("describe");
String money = request.getParameter("money");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>付款页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<div
		style="width:80%;height:60%;border:#A8CB31 1px solid;border-radius:20px;margin-top:20%;margin-left:10%">
		
		<div style="width:90%;margin-left:5%"><p style="font-size:50px">付款后我们将第一时间为您发货</p>
		<p style="font-size:50px">您还可以点击订单查询来查询您的订单状态</p>
		<p style="font-size:50px">你购买的商品由省省吧提供</p>
		<p style="font-size:50px"> 您将付款金额：<%=money %></p>
		</div>
		<input type="button"
			style="margin-left:35%;margin-top:10%;background:#A8CB31;width:200px;
  			height:80px;font-size:40px;border-radius:20px;color:white;"
			value="立即付款" onclick="callpay()">
	</div>
</body>
<script type="text/javascript">
  //支付页面调用支付API
  	function callpay(){
		 WeixinJSBridge.invoke('getBrandWCPayRequest',{
  		 "appId" : "<%=appId%>","timeStamp" : "<%=timeStamp%>", "nonceStr" : "<%=nonceStr%>", "package" : "<%=packageValue%>","signType" : "MD5", "paySign" : "<%=paySign%>" 
   			},function(res){
				WeixinJSBridge.log(res.err_msg);
// 				alert(res.err_code + res.err_desc + res.err_msg);
	            if(res.err_msg == "get_brand_wcpay_request:ok"){  
	                alert("微信支付成功!");  
	            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
	                alert("用户取消支付!");  
	            }else{  
	               alert("支付失败!");  
	            }  
			})
		}
  </script>

</html>
