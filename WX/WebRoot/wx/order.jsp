<i><%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%> <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
	 <%@ taglib prefix="s" uri="/struts-tags" %>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
<head>
<base href="<%=basePath%>">

<title>浙江移动流量共享</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="bootstrapmin/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript" src="bootstrapmin/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery/jquery.min.js"></script>

<style>
	.btn{width:30%;border:#dfe0e5 5px solid;height:8%;background:white;margin-left:15px;margin-top:40px;margin-right:15px;font-size:40px;
                border-radius:20px;font-family:'方正细园';  
  	}
  		.tp{width:50%;height:80% ;float:left;margin-top:10px;}
  	.zanshi{margin:0 auto ;text-align:center;border:gray 1px solid;margin-top:20px;margin-bottom:20px;width:90%;height:30%;}
  	.sm{font-size:40px;}
  	.bt{float:left;width:50%;height:25%;}
  	.tableo{width:80%;margin-left:10%;font-size:40px}
  	tr{margin-top:20px;}
  </style>
</head>
<script type="text/javascript">
	$(function() {
		$('#order').css({
			"border" : '5px solid #0fae6e'
		})
	})
	function one(a){
		location.href='index.jsp'
	}
	function two(a){
		location.href='sw!showShiwu'
	}
	function qing(a){
		$(a).val("")
	}
	$(function(){
		$('#order').css({"border":'5px solid #0fae6e'})
	$('#order').addClass("boxshadow")
	})
</script>
<body>
	<button id="xn" class="btn yi" onclick="one(this)">虚拟</button>
	<button id=sw  class="btn yi" onclick="two(this)">实物</button>
	<button id="order" class="btn yi" onclick="three(this)">订单查询</button>
		
	<div  style="width:90%;margin-top:50px;margin-bottom:20px;margin-left:10%" >
		<input id=phone type=text onclick=qing(this) value="请输入手机号" style="width:70%;height:90px;font-size:50px;line-height:100%"  />
		
		<input type="button" value=查询 onclick=selOrder()  class=btn style="background:#A8CB31;color:white;width:18%;height:90px;display:inline;margin-top:0px;" />
	</div>
<script>
	function selOrder(){
	
	
		var phone=$("#phone").val()
		location.href='selPhone?phone='+phone
	}
</script>
	<c:forEach items="${orders}" var="order">
	<div style="border:5px solid #A8CB31;border-radius:20px;width:80%;margin-left:10%;margin-bottom:10px" >
<table class=tableo style="line-height:200%">
	<tr>
		<td width=50% >商品名称  &nbsp;&nbsp;&nbsp;</td>
		<td>${order.name} </td>
	</tr>
	<tr>
		<td width=50% >手机号 &nbsp;&nbsp;&nbsp;</td>
		<td>${order.phone}  </td>
	</tr>
	<tr>
		<td width=50% >物流地址   &nbsp;&nbsp;&nbsp;</td>
		<td>${order.adress}  </td>
	</tr>
	<tr>
		<td width=50% >金额   &nbsp;&nbsp;&nbsp;</td>
		<td>${order.money} </td>
	</tr>
	<tr>
		<td width=50% >下单时间   &nbsp;&nbsp;&nbsp;</td>
		<td>${order.paytime} </td>
	</tr>
	<tr>
		<td width=50% >订单状态  &nbsp;&nbsp;&nbsp;</td>
		<td><c:if test="${order.status==1}">已发货</c:if>
					<c:if test="${order.status==0}">未发货</c:if>
					<c:if test="${order.status==3}">发货失败</c:if>
					</td>
	</tr>
		<tr>
		<td width=50% >备注   &nbsp;&nbsp;&nbsp;</td>
		<td>${order.remark} </td>
	</tr>
</table>
</div>
	</c:forEach>
</body>
	</html> </i>