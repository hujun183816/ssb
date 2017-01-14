<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"
	href="bootstrapmin/bootstrap.min.css">
<script type="text/javascript" src="bootstrapmin/bootstrap.min.js"></script>
<script type="text/javascript" src="jquery/jquery.min.js"></script>

<style>
	#first{margin-top:100px;margin-left:10%;}
	.table{width:80%;margin-left:10%}
</style>
  </head>
 <body>
	<div id=first >
		<input type=button value=上传实物商品 class= btn-success onclick="location.href='wxht/up.jsp'"/>
		<input type=button value=代发货订单 class= btn-success onclick="location.href='selOrderDai'"/>
		<input type=button value=在售商品  class= btn-success onclick="location.href='zaiShou'" />
		<input type=button value=已发货订单  class= btn-success onclick="location.href='selOrderYi'" />
		
	</div>
	<div>
		
			<table class=table >
			<thead>
				<tr>
					<th>商品名  &nbsp;&nbsp;&nbsp;</th>
					<th>客户手机   &nbsp;&nbsp;&nbsp;</th>
					<th>物流地址   &nbsp;&nbsp;&nbsp;</th>
					<th>商品金额 &nbsp;&nbsp;&nbsp; </th>
					<th>下单时间 &nbsp;&nbsp;&nbsp; </th>
					<th>订单状态  &nbsp;&nbsp;&nbsp; </th>
					<th>备注  &nbsp;&nbsp;&nbsp; </th>
					<th>操作 &nbsp;&nbsp;&nbsp; </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.name }</td>
					<td>${order.phone }</td>
					<td>${order.adress }</td>
					<td>${order.money }</td>
					<td>${order.paytime }</td>
					
					<td><c:if test="${order.status==1}">已发货</c:if>
					<c:if test="${order.status==0}">未发货</c:if>
					<c:if test="${order.status==3}">发货失败</c:if>
					</td>
					<td>${order.remark }</td>
					<td><c:if test="${order.status==0}"><input type=button value=发货
					  class= btn-success onclick="fahuo('${order.id }')" /></c:if></td>
					
				</tr>
				</c:forEach>
			</tbody>
			
			</table>
		<script>
			function fahuo(a){
				location.href='fahuo0?order.id='+a
			}
		</script>

	</div>
  </body>
</html>
