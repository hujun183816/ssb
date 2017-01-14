<i><%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
<head>
<base href="<%=basePath%>">

<title>浙江移动流量共享</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="bootstrapmin/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript" src="bootstrapmin/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>

<body>
	<button id=xn class="btn yi" onclick=one(this)>虚拟</button>
	<button class="btn yi" onclick="two(this)">实物</button>
	<button class="btn yi" onclick="three(this)">订单查询</button>
	<br />
	<br />
	<hr width="95%" style="border:2px solid #0CAE71;margin-top:50px;margin-left:2%;">
	<div id="main">
		<%@include file="/xuanxiang/xuni.jsp"%>
	</div>
	<br />
	<br />
	<hr width="95%" style="border:2px solid #0CAE71;margin-top:50px;margin-left:2%;">
	<br />
	&nbsp;&nbsp;&nbsp;<a href='' style="font-size:40px;color:black" >业务说明超链接</a>
	<br />
	<button onclick="pay()" class="btn" id=pay 
		style="background:#0CAE71;margin-left:30%;color:white;font-size:40px;width:40%">立即支付：0元</button>
</body>
	</html> </i>