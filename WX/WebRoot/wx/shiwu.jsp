<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%> <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="s" uri="/struts-tags"%> <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
<head>
<base href="<%=basePath%>">

<title>浙江移动流量共享</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="bootstrapmin/bootstrap.min.css">
<script type="text/javascript" src="bootstrapmin/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery/jquery.min.js"></script>

<style>
html{
	font-size:62.5%;
}
.btn{width:30%;border:#dfe0e5 5px solid;height:8%;background:white;margin-left:15px;margin-top:40px;margin-right:15px;font-size:40px;
                border-radius:20px;font-family:'方正细园';  
  	}

.tp {
	width: 400px;
	height: 400px;
	float: left;
	margin-top: 0px;
}

.zanshi {
	margin: 0 auto;
	border: #A8CB31 1px solid;
	border-radius: 15px; margin-top : 20px;
	margin-bottom: 20px;
	width: 800px;
	height: 400px;
	margin-top: 20px;
}

.sm {
	font-size: 40px;
}

.bt {
	float: left;
	width: 50%;
	height: 100%;
}
.boxshadow{
  		box-shadow:-10px 0 10px gray;
  	}
</style>
</head>
<script type="text/javascript">
	$(function() {
		$('#sw').css({
			"border" : '5px solid #0fae6e'
		})
	})
	function one(a) {
		location.href = 'index.jsp'
	}
	function three(a) {
		location.href = 'wx/order.jsp'
	}
	function pay(a) {
		location.href = 'adresssw?body=' + a
	}
	$(function(){
		$('#sw').css({"border":'5px solid #0fae6e'})
	$('#sw').addClass("boxshadow")
	})
</script>
<body>
	<button id="xn" class="btn yi" onclick="one(this)">虚拟</button>
	<button id=sw class="btn yi" onclick="two(this)">实物</button>
	<button class="btn yi" onclick="three(this)">订单查询</button>


	<c:forEach items="${goods}" var="good">
		<div class="zanshi">
			<div class=tp>
				<img style="max-width:100%;max-height:100%" width="100%" height="100%" src="${good.image}">
			</div>

			<div class=bt >
			<br/>
					<div style="font-size:35px;font-family:'隶书';word-warp:break-word;height:30%;line-height:100%" >${good.name}</div>
					<br/>
					<div><button class=btn style="margin-top:5%;background:#A8CB31;width:24rem;height:80px;font-size:40px;border-radius:20px;color:white;"
					onclick="pay('${good.name}'+'/'+'${good.price}'+'/' )">立即付款</button></div>
					<br/>
					<div style="color:red;font-size:35px;margin-top:80px;left:10%">￥${good.price}</div>
			</div>
		</div>
	</c:forEach>
</body>
	</html> 